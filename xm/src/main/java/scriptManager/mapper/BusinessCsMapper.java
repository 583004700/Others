package scriptManager.mapper;

import java.util.List;
import java.util.Map;

public interface BusinessCsMapper {
    /**
     * 查询列表
     * @param map
     * @return
     */
    List<Map> queryList(Map map);
}