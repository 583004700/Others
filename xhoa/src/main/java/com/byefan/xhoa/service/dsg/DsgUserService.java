package com.byefan.xhoa.service.dsg;

import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.dsg.DsgUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DsgUserService {
    @Autowired
    DsgUserMapper userMapper;
    public List<User> tt(){
        return userMapper.ds();
    }
    public void dd(){
        User jj=new User();
        jj.setUserName("lij");
        jj.setPassword("123456");
        jj.setName("邓声根");
        userMapper.dsg(jj);
    }
    public void bb(){
        User kk=new User();
        kk.setName("lij");

        userMapper.up(kk);
    }
}
