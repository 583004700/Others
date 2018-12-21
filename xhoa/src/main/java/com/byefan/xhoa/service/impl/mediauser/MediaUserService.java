package com.byefan.xhoa.service.impl.mediauser;

import com.alibaba.fastjson.JSON;
import com.byefan.core.exception.ByeFanException;
import com.byefan.core.exception.ResultEnum;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.biz.ArticleReturnDown;
import com.byefan.xhoa.entity.media.MediaInfo;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.MediaUserMapper;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.biz.ArticleMapperXML;
import com.byefan.xhoa.mapper.biz.ArticleReturnDownMapper;
import com.byefan.xhoa.service.biz.IArticleService;
import com.byefan.xhoa.service.fee.ICommissionService;
import com.byefan.xhoa.service.impl.sys.UserService;
import com.byefan.xhoa.service.mediauser.IMediaUserService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.utils.AppUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MediaUserService implements IMediaUserService{

    @Autowired
    IArticleService articleService;
    @Autowired
    ArticleReturnDownMapper articleReturnDownMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleMapperXML articleMapperXML;
    @Autowired
    MediaUserMapper mediaUserMapper;
    @Autowired
    IUserService userService;
    /**
     * 媒介管理
     * @param params
     * @return
     */
    public List<Map<String,Object>> list(Map params){
        return articleService.businessList(params);
    }

    /**
     * 媒介分页查询
     * @param param
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Map<String,Object>> listPg(Map param,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return list(param);
    }

    /**
     * 驳回
     * @param article
     */
    @Transactional
    public void turnDown(@RequestParam Article article){
        Article art = articleMapper.get(Article.class,article.getId());
        ArticleReturnDown articleReturnDown = JSON.parseObject(JSON.toJSONString(art), ArticleReturnDown.class);
        articleReturnDown.setReturnDownDate(new Date());
        articleReturnDown.setReturnDownUser(AppUtil.getUser().getId());
        articleReturnDownMapper.insert(articleReturnDown);
        articleMapper.delete(article);
    }

    /**
     * 媒介安排
     * @param article
     * @return
     */
    public int arrange(Article article){
        article.setIssueStates(2);
        return articleMapperXML.changeIssueStates(article);
    }

    /**
     * 媒介发布
     * @param map
     * @param updatePrice
     * @return
     */
    @Transactional
    public int publish(Map map,Integer updatePrice){
        if(StringUtils.isEmpty((String)map.get("id"))){
            throw new ByeFanException(ResultEnum.UNKONW_ERROR);
        }
        map.put("artId",map.get("id"));
        articleService.updateArticle(map);
        Article article = new Article();
        article.setId(Integer.valueOf((String)map.get("id")));
        article.setIssueStates(4);
        int row = articleMapperXML.changeIssueStates(article);
        //需要更新媒体价格
        if(updatePrice!= null &&1 == updatePrice){
            updateMedia(map);
        }

        //查询业务员信息 计算提成
//        Article article2 = articleMapper.get(Article.class,Integer.valueOf((String)map.get("id"))) ;
//        User user = articleMapper.getUserByArticleId(article2.getId()) ;
//        commissionService.updateCommInfo(article2,user);
        return row;
    }

    /**
     * 更新媒体相关信息
     * @param map
     * @return
     */
    public int updateMedia(Map map){
        MediaInfo mediaInfo = new MediaInfo();
        Article fullArticle = articleMapperXML.get(Article.class,Integer.valueOf((String)map.get("id")));
        mediaInfo.setId(fullArticle.getMediaId());
        //更新状态使下单的时候查询不到
        mediaInfo.setState(0);
        int row = mediaUserMapper.updateMediaInfoState(mediaInfo);
        //得到稿件单价
        BigDecimal articleSign = getArticlePayAmount(fullArticle);

        /**
         * 更新媒体表，重新设置单价
         */
        Map paramMap = new HashMap();
        paramMap.put("state",0);
        paramMap.put("priceColumn",fullArticle.getPriceColumn());
        paramMap.put("signPrice",articleSign);
        paramMap.put("id",fullArticle.getMediaId());
        int mrow = mediaUserMapper.updateMediaStatePrice(paramMap);
        return row+mrow;
    }

    /**
     * 媒介移交
     * @param artId
     * @param mediaUserId
     * @return
     */
    public int yj(String artId,String mediaUserId){
        Map map = new HashMap();
        map.put("artId",artId);
        map.put("mediaUserId",mediaUserId);
        User mediaUser = userService.getById(Integer.valueOf(mediaUserId));
        map.put("mediaUserName",mediaUser.getName());
        return articleMapperXML.updateArticle(map);
    }

    /**
     * 通过稿件得到媒体单价
     * @param article
     * @return
     */
    public BigDecimal getMediaPrice(Article article){
        Article fullArticle = articleMapperXML.get(Article.class,article.getId());
        BigDecimal price = mediaUserMapper.getMediaInfoPrice(fullArticle);
        return price;
    }

    /**
     * 通过稿件得到稿件的发布单价
     * @param article
     * @return
     */
    public BigDecimal getArticlePayAmount(Article article){
        Article fullArticle = articleMapperXML.get(Article.class,article.getId());
        BigDecimal payAmount = mediaUserMapper.getArticleOutgoAmount(article);;
        BigDecimal num = new BigDecimal(fullArticle.getNum());
        BigDecimal signPayAmout = payAmount.divide(num,3, RoundingMode.HALF_UP);
        return signPayAmout;
    }

    /**
     * 判断价格浮动是否需要修改媒体的单价
     * @return
     */
    public boolean priceFloat(Article article){
        BigDecimal signPayAmout = getArticlePayAmount(article);
        BigDecimal mediaPrice = getMediaPrice(article);
        //价格浮动
        BigDecimal priceFloat = signPayAmout.subtract(mediaPrice).abs().divide(mediaPrice,3,RoundingMode.HALF_UP);
        return priceFloat.compareTo(new BigDecimal(0.05)) == 1;
    }
}
