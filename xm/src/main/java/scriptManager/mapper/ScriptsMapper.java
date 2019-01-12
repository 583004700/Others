package scriptManager.mapper;

import scriptManager.entity.Scripts;

import java.util.List;
import java.util.Map;

public interface ScriptsMapper {
    /**
     * 添加脚本
     * @param scripts
     * @return
     */
    int addScripts(Scripts scripts);

    /**
     * 查询列表
     * @param map
     * @return
     */
    List<Map> queryList(Map map);

    /**
     * 更新脚本
     * @param scripts
     * @return
     */
    int update(Scripts scripts);
}