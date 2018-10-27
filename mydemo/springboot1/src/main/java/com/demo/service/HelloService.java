package com.demo.service;

import com.demo.mapper.WxMessageMapper;
import com.demo.pojo.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED) //添加了事务，发生异常时将会回滚
public class HelloService {
    @Autowired
    WxMessageMapper wxMessageMapper;
    public void add(){
        WxMessage wxMessage = new WxMessage();
        wxMessage.setFromusername("sdlfks");
        wxMessage.setTousername("sjfjoo");
        wxMessage.setCreatetime(new Date());
        wxMessage.setMsgtype("type");
        wxMessageMapper.insertSelective(wxMessage);
        try {
            int c = 1 / 0;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<WxMessage> getAll(){
        return wxMessageMapper.getAll();
    }

    //@Cacheable(value = "WxMessage", key = "'WxMessage'.concat(#id.toString())")
    public WxMessage get(Integer id){
        return wxMessageMapper.selectByPrimaryKey(id);
    }
}
