package com.byefan.xhoa.service.impl.crm;

import com.byefan.xhoa.entity.crm.DockingChangeRecord;
import com.byefan.xhoa.entity.crm.DockingPeople;
import com.byefan.xhoa.mapper.crm.DockingChangeRecordMapper;
import com.byefan.xhoa.service.crm.IDockingChangeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DockingChangeRecordService implements IDockingChangeRecordService{
    @Autowired
    DockingChangeRecordMapper dockingChangeRecordMapper;
    /**
     * 对接人变更
     * @param peo
     * @param record
     * @return
     */
    public boolean changeDocking(DockingPeople peo, DockingChangeRecord record){
        record.setDockingId(peo.getId());
        record.setChangeTime(new Date());
        int row = dockingChangeRecordMapper.add(record);
        return row > 0;
    }
}
