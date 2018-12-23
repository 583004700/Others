package com.byefan.xhoa.service.impl.crm;

import com.byefan.xhoa.entity.crm.CustUsers;
import com.byefan.xhoa.mapper.crm.CustUsersMapper;
import com.byefan.xhoa.service.crm.ICustUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CustUsersService implements ICustUsersService{
    private static final String CACHE_KEY = "custUsers";

    @Autowired
    CustUsersMapper custUsersMapper;

    public CustUsers selectOne(CustUsers custUsers){
        return custUsersMapper.get(CustUsers.class,custUsers.getId());
    }

    public boolean update(CustUsers custUsers){
        if(custUsers.getId() == null || custUsers.getId() ==0){
            return false;
        }
        custUsersMapper.update(custUsers);
        return true;
    }
}
