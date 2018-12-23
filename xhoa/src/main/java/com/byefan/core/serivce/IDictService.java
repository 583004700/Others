package com.byefan.core.serivce;

import com.byefan.core.entity.Dict;

import java.util.List;
import java.util.Map;

public interface IDictService {
    String CACHE_KEY_LIST = "dictList";

    void initdictEnum() throws Exception;

    Dict getByTypeCodeAndCode(Dict dict);

    List<Dict> list(Dict dict);

    List<Dict> listByTypeCode(String typeCode);

    List<Map<String, Object>> list(Map<String, Object> param);

    List<Map<String, Object>> listByTypeCode(Map<String, Object> param);

    Dict getByTypeCodeAndName(String typeCode, String name);
}
