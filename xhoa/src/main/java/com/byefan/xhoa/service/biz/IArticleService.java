package com.byefan.xhoa.service.biz;

import com.byefan.xhoa.entity.biz.Article;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface IArticleService {

    String CACHE_KEY = "article";
    String CACHE_KEY_LIST = "articleList";

    @Transactional(readOnly = true)
    List<Map<String, Object>> businessList(Map params);

    /**
     * 导出稿件
     *
     * @param map
     * @param outputStream
     * @return
     */
    List<Map> exportAll(Map map, OutputStream outputStream);

    /**
     * 稿件数据管理
     *
     * @param params
     * @return
     */
    List<Map> articleListManager(Map params);

    Map businessResult(Map map);

    Map editArticle(Map map);

    int updateArticle(Map map);

    int deleteArticle(Integer id);

    List<Article> queryArticleForComm(Integer userId, Integer year, Integer month);

    /**
     * 根据订单ID删除稿件信息
     * @param orderId
     * @return
     */
    @Transactional
    @CacheEvict(value = CACHE_KEY)
    int delByOrderId(Integer orderId);

    boolean batchDelete(String datas) throws Exception;

    @Transactional
    @Cacheable(value = CACHE_KEY, key = "#article.id")
    Article save(Article article);

    @Transactional
    boolean saveBatch(List<Article> article);

    @Transactional
    boolean updateBatch(List<Article> article);

    @Transactional
    PageInfo<Article> listByOrderId(Integer orderId, Pageable pageable);


    List<Article> listByOrderId(Integer orderId);


    Article getById(Integer id);

    boolean updatePathById(Integer id, String path);

    PageInfo<Map> queryArticleBySupplierId(Pageable pageable, Integer supplierId, Map map);

    PageInfo<Map> queryArticleForComm(Pageable pageable, Map map);
}
