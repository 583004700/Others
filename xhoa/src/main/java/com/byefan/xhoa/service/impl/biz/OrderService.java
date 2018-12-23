package com.byefan.xhoa.service.impl.biz;

import com.byefan.core.exception.ByeFanException;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.biz.Order;
import com.byefan.xhoa.mapper.biz.OrderMapper;
import com.byefan.xhoa.service.biz.IArticleService;
import com.byefan.xhoa.service.biz.IOrderService;
import com.byefan.xhoa.service.crm.IDockingPeopleService;
import com.byefan.xhoa.utils.AppUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    IArticleService articleService;
    @Autowired
    IDockingPeopleService dockingPeopleService;

    @Override
    @Transactional
    public Order save(Order order) {
        try {
            order.setNo("MTGJ" + UUIDUtil.get16UUID().toUpperCase());
            order.setCreateDate(new Date());
            order.setState(0);
            Integer userId = AppUtil.getUser().getId();
            order.setCreator(userId);
            order.setUpdateUserId(userId);
            orderMapper.save(order);
            order.getArticles().forEach(article -> article.setOrderId(order.getId()));
            articleService.saveBatch(order.getArticles());
            return order;
        } catch (ByeFanException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Order update(Order order) {
        order.setState(1);
        order.setUpdateUserId(AppUtil.getUser().getId());
        orderMapper.update(order);
        articleService.updateBatch(order.getArticles());
        return order;
    }

    @Override
    @Cacheable(value = CACHE_KEY, key = "'orderId='+#id")
    @Transactional(readOnly = true)
    public Order get(Integer id) {
        return orderMapper.get(Order.class, id);
    }

    @Override
    public Order getByNo(String no) {
        return orderMapper.getByNo(no);
    }

    @Override
    public PageInfo<Order> list(Order order, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Order> list = orderMapper.search(order);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Order> listByUserId(Integer userId) {
        return null;
    }
    /**
     * 根据订单ID删除订单信息
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = CACHE_KEY, key = "'orderId='+#orderId")
    public boolean delById(Integer orderId) {
        int retInt = orderMapper.delById(Order.class, orderId);
         articleService.deleteArticle(orderId);
         return true;
    }
}
