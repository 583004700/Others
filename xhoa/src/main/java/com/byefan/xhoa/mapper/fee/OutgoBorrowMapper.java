package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.OutgoBorrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OutgoBorrowMapper extends BaseMapper<OutgoBorrow,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(OutgoBorrow t);

    @UpdateProvider(type = ProviderUtil.class, method = "update")
    int update2(OutgoBorrow record);

    @Select("select * from fee_outgo_borrow where  id = #{id}")
    OutgoBorrow getById(Integer id);

    @Select("select b.* from fee_outgo_borrow b where  b.outgo_id = #{outgoId} and b.borrow_id = #{borrowId}")
    OutgoBorrow getByOutgoIdAndBorrowId(@Param("outgoId") Integer outgoId, @Param("borrowId") Integer borrowId);

    @Select("select b.* from fee_outgo_borrow b where  b.outgo_id = #{outgoId}")
    List<OutgoBorrow> queryBorrowById(@Param("outgoId") Integer outgoId);

    @Select("select b.* from fee_outgo_borrow b where  b.borrow_id = #{borrowId}")
    List<OutgoBorrow> queryBorrowByBorrowId(@Param("borrowId") Integer borrowId);

    @Delete("delete from fee_outgo_borrow where outgo_id = #{outgoId}")
    void deleteByOutgoId(@Param("outgoId") Integer outgoId) ;

    @Delete("delete from fee_outgo_borrow where borrow_id = #{borrowId}")
    void deleteByBorrowId(@Param("borrowId") Integer borrowId) ;

}
