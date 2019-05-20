package common.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseMapper<T> {
    /**
     * 添加一条记录
     * @param obj 要插入的对象
     * @return
     */
    @InsertProvider(type=EntityProvider.class,method = "insert")
    int insert(T obj);

    /**
     * 通过主键更新记录
     * @param obj 要更新的对象
     * @return
     */
    @UpdateProvider(type=EntityProvider.class,method = "updateByPrimaryKey")
    int updateByPrimaryKey(Object obj);

    /**
     * 更新指定列通过指定的条件
     * @param propertyColumns 要更新的列，用,分隔
     * @param whereColumns 条件列，用,分隔
     * @param obj   要更新的对象
     * @return
     */
    @UpdateProvider(type=EntityProvider.class,method = "update")
    int update(String propertyColumns,String whereColumns,Object obj);
}
