package com.byefan.xhoa.mapper.sys;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.sys.AutoNumber;
import com.byefan.xhoa.entity.sys.Role;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AutoNumberMapper extends BaseMapper<AutoNumber, Integer> {

    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(AutoNumber t);

    @Select("select Max(value) from auto_number where code=#{code} and year=#{year} and month=#{month} ")
    Integer getMaxCode(@Param("code") String code,@Param("year") Integer year,@Param("month") Integer month) ;

}
