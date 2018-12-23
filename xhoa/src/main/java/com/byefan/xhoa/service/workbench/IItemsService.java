package com.byefan.xhoa.service.workbench;

import com.byefan.xhoa.entity.workbench.Items;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IItemsService {
    PageInfo<Map> list(Map item, Pageable pageable);
    //添加一个事项
    boolean addItems(Items item);
    //返回ID
    int addItemsReturnId(Items item);
    //将事项设为已办
    boolean finishItems(Items items);
}
