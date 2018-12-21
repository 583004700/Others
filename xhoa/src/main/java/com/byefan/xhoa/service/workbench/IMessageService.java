package com.byefan.xhoa.service.workbench;

import com.byefan.xhoa.entity.workbench.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IMessageService {
    PageInfo<Map> list(Map item, Pageable pageable);

    boolean readMessage(Message message);

    boolean addMessage(Message message);
}
