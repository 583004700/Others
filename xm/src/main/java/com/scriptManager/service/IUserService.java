package com.scriptManager.service;

import com.scriptManager.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> queryList();
    User queryOne(Map map);
}
