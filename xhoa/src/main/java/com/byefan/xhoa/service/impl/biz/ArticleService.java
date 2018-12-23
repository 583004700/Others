package com.byefan.xhoa.service.impl.biz;

import com.alibaba.fastjson.JSON;
import com.byefan.core.utils.DateUtils;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.biz.ArticleMapperXML;
import com.byefan.xhoa.service.biz.IArticleService;
import com.byefan.xhoa.service.media.IMediaTypeService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.ExcelUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.util.*;

@Slf4j
@Service
@Transactional
public class ArticleService implements IArticleService {
    @Autowired
    ArticleMapperXML articleMapperXML;
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    IMediaTypeService mediaTypeService;

    /**
     * 查询稿件数据，或者表格选中的
     * @param params
     * @return
     */
    public List<Map<String, Object>> businessList(Map params) {
        if(AppUtil.getUser().getCurrentDeptQx()){
            params.remove("saleman");
            params.remove("mediaUserId");
            params.put("currentDeptQx","true");
            params.put("deptId",AppUtil.getUser().getDeptId());
        }

        if(params.containsKey("datas")){
            List<Article> articles = JSON.parseArray((String)params.get("datas"),Article.class);
            List<Map<String,Object>> ds = new ArrayList<Map<String,Object>>();
            for(Article article: articles){
                Map art = businessOne(article.getId());
                if(art != null){
                    ds.add(art);
                }
            }
            return ds;
        }
        return articleMapperXML.businessList(params);
    }

    /**
     * 稿件数据管理
     * @param params
     * @return
     */
    public List<Map> articleListManager(Map params) {
        if(params.containsKey("datas")){
            List<Article> articles = JSON.parseArray((String)params.get("datas"),Article.class);
            List<Map> ds = new ArrayList<Map>();
            for(Article article: articles){
                Map art = businessOne(article.getId());
                if(art != null){
                    ds.add(art);
                }
            }
            return ds;
        }
        return articleMapperXML.articleListManager(params);
    }

    /**
     * 稿件统计数据
     * @param map
     * @return
     */
    public Map businessResult(Map map){
        return articleMapperXML.businessResult(map);
    }

    /**
     * 根据artId查询一条数据
     * @param artId
     * @return
     */
    public Map businessOne(Integer artId){
        Map map = new HashMap();
        map.put("artId",artId);
        List<Map<String,Object>> arts = articleMapperXML.businessList(map);
        if(arts != null && arts.size() >= 1){
            return arts.get(0);
        }
        return null;
    }

    /**
     * 稿件导出
     * @param map
     * @param outputStream
     * @return
     */
    public List<Map> exportAll(Map map, OutputStream outputStream) {
        List<Map<String,Object>> list = businessList(map);
        String[] heads = {"订单编号", "客户公司", "对接人信息", "标题", "金额", "支付状态", "类别", "媒体", "标题", "品牌", "链接", "发布日期", "客户报价","客户答应到款日期","媒介"};
        String[] fields = {"orderNo", "companyName", "dockingName", "orderTitle", "amount", "state", "mTypeName", "mediaName", "title", "brand","link","issuedDate","saleAmount","promiseDate","mediaUserName"};
        ExcelUtil.exportExcel("稿件信息", heads, fields, list, outputStream, "yyyy-MM-dd", (sheet, rowIndex, cellIndex, row, cell, field, value) -> {
            if (value != null) {
                if ("state".equals(field)) {
                    if ((int) value == 0) {
                        cell.setCellValue("未下单");
                    } else if ((int) value == 1) {
                        cell.setCellValue("已下单");
                    }
                } else if ("issuedDate".equals(field) || "promiseDate".equals(field)) {
                    cell.setCellValue(DateUtils.format((Date) value, DateUtils.DEFAULT));
                } else {
                    cell.setCellValue(value.toString());
                }
            }
        });
        return null;
    }

    public Map editArticle(Map map){
        return articleMapperXML.editArticle(map);
    }

    public int updateArticle(Map map){
        return articleMapperXML.updateArticle(map);
    }

    public int deleteArticle(Integer id){
        return articleMapperXML.deleteArticle(id);
    }

    @Transactional
    public boolean batchDelete(String datas) throws Exception{
        List<Article> articles = JSON.parseArray(datas,Article.class);
        for(int i=0;i<articles.size();i++){
            int row = this.deleteArticle(articles.get(i).getId());
            if(row < 1){
                throw new Exception("批量删除失败");
            }
        }
        return true;
    }

    @Override
    public Article save(Article article) {
        Integer id = articleMapper.save(article);
        article.setId(id);
        return article;
    }

    @Override
    public boolean saveBatch(List<Article> article) {
        articleMapperXML.saveBatch(article);
        return true;
    }

    @Override
    public boolean updateBatch(List<Article> article) {
        articleMapperXML.updateBatch(article);
        return true;
    }

    @Override
    public PageInfo<Article> listByOrderId(Integer orderId, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Article> list = articleMapper.listByOrderId(orderId);
        list.forEach(article -> {
            article.setMediaType(mediaTypeService.getByMediaId(article.getMediaId()));
        });
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    @Transactional
    @Cacheable(value = CACHE_KEY_LIST, key = "#orderId")
    public List<Article> listByOrderId(Integer orderId) {
        return articleMapper.listByOrderId(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_KEY, key = "'id='+#Id")
    public Article getById(Integer id) {
        return articleMapper.get(Article.class, id);
    }

    @Override
    public boolean updatePathById(Integer id, String path) {
        articleMapper.updatePathById(id, path);
        return true;
    }

    @Override
    public PageInfo<Map> queryArticleBySupplierId(Pageable pageable,Integer supplierId,Map map) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Map> list = articleMapper.queryArticleBySupplierId(supplierId,map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Map> queryArticleForComm(Pageable pageable,Map map) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Map> list = articleMapper.queryArticleForComm(map);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Article> queryArticleForComm(Integer userId, Integer year, Integer month) {
        return articleMapper.queryArticleForComm2(userId,year,month);
    }
    /**
     * 根据订单ID删除稿件信息
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = CACHE_KEY)
    public int delByOrderId(Integer orderId) {
        return articleMapper.delByOrderId(orderId);
    }
}
