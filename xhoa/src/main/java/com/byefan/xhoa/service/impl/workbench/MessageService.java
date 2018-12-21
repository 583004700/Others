package com.byefan.xhoa.service.impl.workbench;

import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.workbench.Message;
import com.byefan.xhoa.entity.workbench.MessageRead;
import com.byefan.xhoa.mapper.workbench.MessageMapper;
import com.byefan.xhoa.mapper.workbench.MessageReadMapper;
import com.byefan.xhoa.service.workbench.IMessageService;
import com.byefan.xhoa.utils.AppUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MessageService implements IMessageService{
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    MessageReadMapper messageReadMapper;

    /**
     * 查询消息
     * @param item
     * @param pageable
     * @return
     */
    public PageInfo<Map> list(Map item, Pageable pageable){
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        item.put("userId", AppUtil.getUser().getId());
        item.put("userDept", AppUtil.getUser().getDeptId());
        List<Map> items = messageMapper.listMsg(item);
        PageInfo<Map> pageInfo = new PageInfo<Map>(items);
        return pageInfo;
    }

    /**
     * 读取消息
     * @param message
     * @return
     */
    public boolean readMessage(Message message){
        MessageRead messageRead = new MessageRead(AppUtil.getUser().getId(),message.getId(),new Date());
        messageReadMapper.insert(messageRead);
        return true;
    }

    /**
     * 添加一条消息
     * @param message
     * @return
     */
    public boolean addMessage(Message message){
        message.setState(Const.MESSAGE_STATE_W);
        message.setCreateTime(new Date());
        messageMapper.insert(message);
        return true;
    }
}
