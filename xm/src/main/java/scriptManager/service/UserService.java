package scriptManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scriptManager.entity.User;
import scriptManager.mapper.UserMapper;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }

    public User queryOne(Map map){
        return userMapper.queryOne(map);
    }
}
