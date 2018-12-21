package com.byefan.xhoa.service.crm;

import com.byefan.xhoa.entity.crm.CustUsers;

public interface ICustUsersService {

    CustUsers selectOne(CustUsers custUsers);

    boolean update(CustUsers custUsers);
}
