package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.IncomeArticle;
import org.apache.ibatis.annotations.*;

public interface IncomeArticleMapper extends BaseMapper<IncomeArticle,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(IncomeArticle t);

    @UpdateProvider(type = ProviderUtil.class, method = "update")
    int update2(IncomeArticle record);

    @Select("select * from fee_income_article where state>-2 and id = #{id}")
    IncomeArticle getById(Integer id);

    @Select("select b.* from fee_income_article b where b.state>-2 and b.income_id = #{incomeId} and b.article_id = #{articleId}")
    IncomeArticle getIncomeArticle(@Param("incomeId") Integer incomeId, @Param("articleId") Integer articleId);

    @Update("delete from fee_income_article where income_id = #{incomeId}")
    void deleteIncomeArticleByIncomeId(@Param("incomeId") Integer incomeId) ;

    @Delete("delete from fee_income_article where income_id = #{incomeId} and article_id = #{articleId}")
    void deleteIncomeArticleByArticleId(@Param("incomeId") Integer incomeId, @Param("articleId") Integer articleId) ;

}
