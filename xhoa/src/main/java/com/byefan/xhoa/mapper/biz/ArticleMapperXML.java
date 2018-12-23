package com.byefan.xhoa.mapper.biz;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.biz.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleMapperXML extends BaseMapper<Article,Integer>{
    /**
     * 业务查询
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> businessList(Map map);

    /**
     * 稿件统计
     * @param map
     * @return
     */
    Map businessResult(Map map);

    /**
     * 稿件查询管理
     * @param map
     * @return
     */
    List<Map> articleListManager(Map map);

    /**
     * 编辑稿件时查出稿件信息
     * @param map
     * @return
     */
    Map editArticle(Map map);

    /**
     * 更新稿件信息
     * @param map
     * @return
     */
    int updateArticle(Map map);

    /**
     * 删除稿件
     * @param id
     * @return
     */
    int deleteArticle(@Param("artId") Integer id);

    /**
     * 改变稿件状态
     * @param article
     * @return
     */
    int changeIssueStates(Article article);

    void saveBatch(List<Article> article);

    void updateBatch(List<Article> article);
}
