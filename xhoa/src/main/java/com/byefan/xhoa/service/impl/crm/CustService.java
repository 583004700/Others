package com.byefan.xhoa.service.impl.crm;

import com.byefan.core.utils.DateUtils;
import com.byefan.xhoa.entity.crm.*;
import com.byefan.xhoa.mapper.crm.*;
import com.byefan.xhoa.service.crm.ICustService;
import com.byefan.xhoa.service.crm.IDockingChangeRecordService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.ExcelUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.flowable.spring.boot.app.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CustService implements ICustService {
    @Autowired
    CustMapper custMapper;
    @Autowired
    DockingPeopleMapper dockingPeopleMapper;
    @Autowired
    ProductInfoMapper productInfoMapper;
    @Autowired
    CustUsersMapper custUsersMapper;
    @Autowired
    CustDockingPeopleMapper custDockingPeopleMapper;
    @Autowired
    DockingChangeRecordMapper dockingChangeRecordMapper;
    @Autowired
    IDockingChangeRecordService dockingChangeRecordService;

    @Override
    public List<Cust> list() {
        return custMapper.getCusts();
    }

    /**
     * 添加一个完整客户信息
     *
     * @param cust
     * @param dockingPeople
     * @param productInfo
     * @param custUsers
     * @return
     */
    @CacheEvict(value = CACHE_KEY_LIST,key = "#dockingPeople.worker")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean add(String op, Cust cust, DockingPeople dockingPeople, ProductInfo productInfo, CustUsers custUsers) {
        Cust c = custMapper.getByCompanyName(cust.getCompanyName());
        //如果公司已经存在
        if (c != null && c.getId() != null) {
            cust = c;
        } else {
            int row = custMapper.add(cust);
            if (row < 1) {
                return false;
            }
        }
        if (cust.getId() != 0) {
            dockingPeople.setCompanyId(cust.getId());
            productInfo.setCompanyId(cust.getId());
            custUsers.setCompanyId(cust.getId());
            if ("addDocking".equals(op)) {
                int rowd = dockingPeopleMapper.add(dockingPeople);
            } else if ("addProduct".equals(op)) {
                int rowp = productInfoMapper.add(productInfo);
            } else if ("addUsers".equals(op)) {
                int rowc = custUsersMapper.add(custUsers);
            } else {
                int rowd = dockingPeopleMapper.add(dockingPeople);
                int rowp = productInfoMapper.add(productInfo);
                int rowc = custUsersMapper.add(custUsers);
            }
            return true;
        }
        return false;
    }

    /**
     * 判断对接人是否重复
     *
     * @return
     */
    public boolean isRepeat(String companyName, String custName) {
        Cust cust = custMapper.getByCompanyName(companyName);
        if (cust != null) {
            for (DockingPeople d : cust.getDockingPeoples()) {
                if (custName.equals(d.getCustName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据权限添加过滤条件
     */
    private void addCondition(Map map) {
        boolean b = AppUtil.getUser().getCurrentDeptQx();
        //默认只查询出自己负责的对接人
        if(!b){
            map.put("workerId", AppUtil.getUser().getId());
        }else{
            map.remove("workerId");
            map.put("currentDeptQx","true");
            map.put("deptId",AppUtil.getUser().getDeptId());
        }
    }

    /**
     * 根据条件获取客户列表
     */
    private List<Map> customList(Map map) {
        addCondition(map);
        List<Map> list = custDockingPeopleMapper.getCustdockingPeopleSearch(map);
        return list;
    }

    /**
     * 查询客户列表
     *
     * @param pageNum
     * @param pageSize
     * @param map
     * @return
     */
    public PageInfo<Map> getCustDockingPeopleVo(Integer pageNum, Integer pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Map> pageInfo = new PageInfo(customList(map));
        return pageInfo;
    }

    /**
     * 导出查询到的全部客户
     *
     * @param map
     * @param outputStream
     * @return
     */
    public List<Map> exportAll(Map map, OutputStream outputStream) {
        List<Map> list = customList(map);
        String[] heads = {"编号", "客户名称", "地区公司", "客户联系人", "职位", "状态", "创建人", "负责人", "创建日期", "更新日期"};
        String[] fields = {"id", "companyName", "area", "custName", "job", "status", "createWorkerName", "workerName", "createTime", "updateTime"};
        ExcelUtil.exportExcel("客户信息", heads, fields, list, outputStream, "yyyy-MM-dd", (sheet, rowIndex, cellIndex, row, cell, field, value) -> {
            if (value != null) {
                if ("status".equals(field)) {
                    if ((int) value == 0) {
                        cell.setCellValue("有效");
                    } else if ((int) value == 1) {
                        cell.setCellValue("待开发");
                    } else if ((int) value == 2) {
                        cell.setCellValue("流失");
                    }
                } else if ("createTime".equals(field) || "updateTime".equals(field)) {
                    cell.setCellValue(DateUtils.format((Date) value, DateUtils.DEFAULT));
                } else {
                    cell.setCellValue(value.toString());
                }
            }
        });
        return list;
    }

    /**
     * 取消绑定
     *
     * @param peo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean cancelDocking(DockingPeople peo) {
        peo.setWorker(null);
        peo.setCustProperty(Const.CUST_PROPERTY_GONGHAI);
        int row = dockingPeopleMapper.cancelOrBindDocking(peo);

        //插入变更记录表
        DockingChangeRecord record = new DockingChangeRecord();
        record.setCurrentWorker(AppUtil.getUser().getId());
        //写入到变更记录表
        boolean c = dockingChangeRecordService.changeDocking(peo, record);
        return row > 0 && c;
    }

    /**
     * 认领
     *
     * @param peo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean bindDocking(DockingPeople peo) throws Exception {
        //认领
        DockingPeople dockingPeople = dockingPeopleMapper.get(DockingPeople.class, peo.getId());
        if (dockingPeople.getWorker() != null && !dockingPeople.getWorker().equals("")) {
            //有负责人时不能认领
            throw new Exception("当前对接人已有负责人");
        }
        ;
        peo.setWorker(AppUtil.getUser().getId());
        peo.setCustProperty(Const.CUST_PROPERTY_FEIGONGHAI);
        int row = dockingPeopleMapper.cancelOrBindDocking(peo);

        DockingChangeRecord record = new DockingChangeRecord();
        record.setNewWorker(AppUtil.getUser().getId());
        //写入到变更记录表
        boolean c = dockingChangeRecordService.changeDocking(peo, record);
        return row > 0 && c;
    }

    /**
     * 批量交接或指派
     *
     * @param peos
     * @param record
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean batchBindDocking(List<DockingPeople> peos, DockingChangeRecord record, int bz) throws Exception {
        if (record.getNewWorker() == null) {
            throw new Exception("交接不能没有负责人");
        }
        for (int i = 0; i < peos.size(); i++) {
            DockingPeople dockingPeople = peos.get(i);
            dockingPeople.setWorker(record.getNewWorker());
            int row = dockingPeopleMapper.updateDocking(dockingPeople);
            //插入变更记录
            if (bz != 2) {
                //如果是交接
                record.setCurrentWorker(AppUtil.getUser().getId());
            }
            boolean b = dockingChangeRecordService.changeDocking(dockingPeople, record);
            if (!b || row < 1) {
                throw new Exception("批量交接失败");
            }
        }
        return true;
    }


    /**
     * 启用或停用
     *
     * @param peo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean stopOrOpen(DockingPeople peo) {
        int row = dockingPeopleMapper.updateDocking(peo);
        return row > 0;
    }

    /**
     * 根据公司ID查询公司信息
     *
     * @param id
     * @return
     */
    //@Cacheable(value="Cust",key="#id")
    public Cust custInfo(Integer id) {
        Cust cust = custMapper.getByCompanyId(id);
        return cust;
    }

    /**
     * 更新公司信息
     *
     * @param cust
     * @return
     */
    public boolean updateCompany(Cust cust) {
        if (cust.getId() == null || cust.getId() == 0) {
            return false;
        }
        custMapper.update(cust);
        return true;
    }

    /**
     * 行业下拉框
     *
     * @return
     */
    @Cacheable(value = "sys_wd_hy")
    public List<Map> hySelect() {
        return custMapper.hySelect();
    }

    @Cacheable(value = CACHE_KEY_LIST, key = "#worker")
    @Override
    public List<Cust> listByWorker(Integer worker) {
        return custMapper.listByWorker(worker);
    }

    @Override
    public PageInfo<Map> getCustDockingPeople(Integer pageNum, Integer pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
//        addCondition(map);
        List<Map> list = custDockingPeopleMapper.getCustdockingPeople(map);
        PageInfo<Map> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
