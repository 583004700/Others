package scriptManager.mapper;

import scriptManager.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> queryList();
    User queryOne(Map map);
}