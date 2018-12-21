package com.byefan.core.mapper;

import com.byefan.core.entity.Dict;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 查询字典数据
 */
public interface DictMapper extends BaseMapper<Dict, Integer> {

    @Select("select * from sys_dict where type_code=#{typeCode} and disabled=0 order by sort_no")
    List<Dict> listByTypeCode(@Param("typeCode") String typeCode);

    @Select("select * from sys_dict where type_code=#{typeCode} and code=#{code}  and disabled=0 order by sort_no")
    Dict getByTypeCodeAndCode(@Param("typeCode") String typeCode, @Param("code") String code);

    @Select("select * from sys_dict where type_code=#{typeCode} and name=#{name}  and disabled=0 order by sort_no")
    Dict getByTypeCodeAndName(@Param("typeCode") String typeCode, @Param("name") String name);
}
