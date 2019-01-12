package scriptManager.service;

import java.util.List;
import java.util.Map;

public interface IDynamicQueryService {

    List<Map> queryList(Map map,String dataSourceKey);

}
