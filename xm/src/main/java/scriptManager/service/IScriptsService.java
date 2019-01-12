package scriptManager.service;

import scriptManager.entity.Scripts;

import java.util.List;
import java.util.Map;

public interface IScriptsService {
    int addScripts(Scripts scripts);
    List<Map> queryList(Map map);
    int update(Scripts scripts);
}
