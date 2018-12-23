package com.byefan.xhoa.service.impl.sys;

import com.alibaba.fastjson.JSONArray;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.mapper.sys.DeptMapper;
import com.byefan.xhoa.service.sys.IDeptService;
import com.byefan.xhoa.utils.DeptJsonUtil;
//import com.byefan.xhoa.utils.DeptTreeUtil;
import com.byefan.xhoa.utils.DeptJsonUtilForTreeView;
import com.byefan.xhoa.utils.IConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptService implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;

//    @Cacheable(value = "dept")
    public List<Dept> listAll() {
        return deptMapper.listAll();
    }

    public List<Dept> listParam(Integer userId){
        return deptMapper.listParam(userId);
    }

    @Override
//    @Cacheable(value = "dept", key = "")
    public JSONArray listForTreeView() {
        JSONArray deptlist = new JSONArray();
        List<Dept> menulist = listAll();
        DeptJsonUtilForTreeView deptJson = new DeptJsonUtilForTreeView();
        deptlist = deptJson.jsonList(menulist) ;
        return deptlist;
    }

    @Override
//    @Cacheable(value = "dept", key = "")
    public JSONArray list() {
        JSONArray deptlist = new JSONArray();
        List<Dept> menulist = listAll();
        DeptJsonUtil deptJson = new DeptJsonUtil();
        deptlist = deptJson.jsonList(menulist) ;
        return deptlist;
    }
    @Override
    public Integer getMaxLevel() {
        return deptMapper.getMaxLevel();
    }

    @Override
    @Cacheable(value = "dept", key = "")
    public List<Dept> queryAllDept(){
        return deptMapper.queryAllDept() ;
    }
    @Override
    @Cacheable(value = "dept", key = "'id='+#id")
    public List<Dept> queryDeptByUserId(Integer id){
        return deptMapper.queryDeptByUserId(id);
    }
    @Override
//    @CacheEvict(value = "dept", key = "'id='+#dept.getId()")
    public void editDept(Dept dept){
        deptMapper.update(dept);
    }
    @Override
    @CacheEvict(value = "dept", key = "'id='+#id")
    public void delDept(Integer id){
        recursiveRemove(id);
        Dept dept = getById(id) ;
        dept.setState(IConst.STATE_DELETE);
        deptMapper.update(dept);
    }

    /**
     * 递归删除,有子部门先删除子部门
     */
    @CacheEvict(value = "dept", key = "'id='+#id")
    public void recursiveRemove(Integer id){
        List<Dept> list = deptMapper.queryDeptByParentId(id) ;
        if(list!=null || list.size()>0){
            for(Dept temp : list){
                recursiveRemove(temp.getId()) ;
                temp.setState(IConst.STATE_DELETE);
                deptMapper.update(temp);
            }
        }
    }
    @Override
    @CachePut(value = "dept", key = "'id='+#id")
    public Dept addChildDept(Map map){
        try {
            Dept childDept = new Dept();
            childDept.setLevel(Integer.parseInt((String) map.get("level1")) + 1);
            childDept.setParentId(Integer.parseInt((String) map.get("parentId1")));
            childDept.setName((String) map.get("name1"));
            childDept.setCode((String) map.get("code1"));
            childDept.setType((String) map.get("type1"));
            childDept.setMgrId(Integer.parseInt((String) map.get("mgrId1")));
            childDept.setMgrName((String) map.get("mgrName1"));
            childDept.setMgrLeaderId(Integer.parseInt((String) map.get("mgrLeaderId1")));
            childDept.setMgrLeaderName((String) map.get("mgrLeaderName1"));
            childDept.setCreator((Integer) map.get("userId"));
            childDept.setState(IConst.STATE_FINISH);
//            childDept.setChildDepts(null);
//            childDept.setDepts(null);
            deptMapper.insert(childDept);
            return  childDept;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    @Cacheable(value = "dept", key = "'id='+#id")
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;
    }

    @Override
    @Cacheable(value = "dept", key = "'name='+#name")
    public List<Dept> queryDeptByName(String name) {
        List<Dept> list = deptMapper.queryDeptByName(name);
        return list;
    }

    /**
     * 根据类型查询部门
     * @param type
     * @return
     */
    @Cacheable("dept")
    public List<Dept> listByType(String type){
        Map map = new HashMap();
        map.put("type",type);
        return deptMapper.listPara(map);
    }
}
