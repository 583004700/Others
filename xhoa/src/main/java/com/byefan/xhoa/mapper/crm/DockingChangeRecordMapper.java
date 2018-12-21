package com.byefan.xhoa.mapper.crm;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.crm.DockingChangeRecord;
import org.apache.ibatis.annotations.InsertProvider;

public interface DockingChangeRecordMapper extends BaseMapper<DockingChangeRecord,Integer>{
    /**
     * 添加一条变更记录
     * @param record
     * @return
     */
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    int add(DockingChangeRecord record);
}
