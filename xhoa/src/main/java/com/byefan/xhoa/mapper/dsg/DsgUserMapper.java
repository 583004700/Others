package com.byefan.xhoa.mapper.dsg;

import com.byefan.xhoa.entity.sys.User;
import com.sun.mail.util.QDecoderStream;

import java.util.List;

public interface DsgUserMapper {
    List<User> ds();
    void dsg(User u);
    void up(User d);


}
