package com.byefan.xhoa.service.crm;

import com.byefan.xhoa.entity.crm.*;
import com.github.pagehelper.PageInfo;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface ICustService {

    String CACHE_KEY_LIST="custList";

    String CACHE_KEY="cust";

    List<Cust> list();

    boolean add(String op,Cust cust, DockingPeople dockingPeople, ProductInfo productInfo, CustUsers custUsers);

    boolean isRepeat(String companyName, String custName);

    PageInfo<Map> getCustDockingPeopleVo(Integer pageNum, Integer pageSize,Map map);

    List<Map> exportAll(Map map, OutputStream outputStream);

    boolean cancelDocking(DockingPeople peo);

    boolean bindDocking(DockingPeople peo) throws Exception;

    public boolean batchBindDocking(List<DockingPeople> peos,DockingChangeRecord record,int bz) throws Exception;

    boolean stopOrOpen(DockingPeople peo);

    Cust custInfo(Integer id);

    boolean updateCompany(Cust cust);

    List<Map> hySelect();

    List<Cust> listByWorker(Integer worker);

    PageInfo<Map> getCustDockingPeople(Integer pageNum, Integer pageSize, Map map);
}
