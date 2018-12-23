package com.byefan.xhoa.service.crm;

import com.byefan.xhoa.entity.crm.DockingChangeRecord;
import com.byefan.xhoa.entity.crm.DockingPeople;

public interface IDockingChangeRecordService {
    boolean changeDocking(DockingPeople peo, DockingChangeRecord record);
}
