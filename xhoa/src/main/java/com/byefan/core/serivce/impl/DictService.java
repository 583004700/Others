package com.byefan.core.serivce.impl;


import com.byefan.core.data.DictiEnum;
import com.byefan.core.entity.Dict;
import com.byefan.core.mapper.DictMapper;
import com.byefan.core.serivce.IDictService;
import com.byefan.core.utils.StrUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.MapUtils;

import java.util.*;


@Service
public class DictService implements IDictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public void initdictEnum() throws Exception {
        List<Dict> dicts = dictMapper.all(Dict.class);
        this.toTree(dicts);
        //用枚举存放数据字典
        for (DictiEnum type : DictiEnum.values()) {
            List<Dict> list = new ArrayList<Dict>();
            for (Dict dict : dicts) {
                if (type.getTypeCode().equals(dict.getTypeCode())) {
                    list.add(dict);
                }
            }
            //加载字典
            type.load(list);
        }
    }

    @Override
    public Dict getByTypeCodeAndCode(Dict dict) {
        return dictMapper.getByTypeCodeAndCode(dict.getTypeCode(), dict.getCode());
    }

    @Override
    public List<Dict> list(Dict dict) {
        return dictMapper.list(dict);
    }

    @Override
    @Cacheable(value = CACHE_KEY_LIST, key = "'typeCode='+#typeCode")
    public List<Dict> listByTypeCode(String typeCode) {
        return dictMapper.listByTypeCode(typeCode);
    }

    @Override
    public List<Map<String, Object>> list(Map<String, Object> param) {
        String sql = "SELECT a.*,b.`type_id`,b.`type`,b.`term_sql`,b.`term_name`,b.`state`,b.name,b.`json`,b.`html`,b.`data_type` FROM (\n" +
                "SELECT * FROM sys_dict WHERE type_code=" + param.get("type_code") + " AND disabled=" + param.get("disabled") + " ) a LEFT JOIN t_media_term b ON a.`code`=b.`name`  ORDER BY  sort_no";
        List<Map<String, Object>> list = dictMapper.dictSQL(sql);
        return list;
    }

    @Override
    public List<Map<String, Object>> listByTypeCode(Map<String, Object> param) {
        String sql = "SELECT a.*,b.`type_id`,b.`type`,b.`term_sql`,b.`term_name`,b.`state`,b.name,b.`json`,b.`html`,b.`data_type` FROM (\n" +
                "SELECT * FROM sys_dict WHERE type_code=" + param.get("type_code") + " AND disabled=0 ) a LEFT JOIN t_media_term b ON a.`code`=b.`name` AND a.type_code=b.TYPE_id ORDER BY  sort_no";
        List<Map<String, Object>> list = dictMapper.dictSQL(sql);
        return list;
    }

    /**
     * Description: 将节点放进父节点
     *
     * @param dicts
     */
    private List<Dict> toTree(List<Dict> dicts) {
        for (Dict dict : dicts) {
            int parentId = dict.getParentId();
            if (-1 == parentId || 0 == parentId) continue;
            for (Dict parent : dicts) {
                if (parentId == parent.getId()) {
                    if (parent.getChilds() == null) {
                        parent.setChilds(new HashSet<Dict>());
                    }
                    parent.getChilds().add(dict);
                    break;
                }
            }
        }
        return dicts;
    }

    @Override
    @Cacheable(value = "dict", key = "'typeCode='+#typeCode+'&name'+#name")
    public Dict getByTypeCodeAndName(String typeCode, String name) {
        return dictMapper.getByTypeCodeAndName(typeCode, name);
    }
}