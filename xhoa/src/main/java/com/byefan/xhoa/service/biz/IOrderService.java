package com.byefan.xhoa.service.biz;

import com.byefan.xhoa.entity.biz.Order;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderService {

    String CACHE_KEY = "order";
    String CACHE_KEY_LIST = "orderList";

    /**
     * 删除订单 取消订单
     *
     * @param orderId
     * @return
     */
    @Transactional
    @CacheEvict(value = CACHE_KEY, key = "'orderId='+#orderId")
    boolean delById(Integer orderId);

    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Transactional
    @CachePut(value = CACHE_KEY, key = "'orderId='+#order.id")
    Order save(Order order);

    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Transactional
    @CachePut(value = CACHE_KEY, key = "'orderId='+#order.id")
    Order update(Order order);

    /**
     * 根据订单ID查询订单信息
     *
     * @param id
     * @return
     */
    @Cacheable(value = CACHE_KEY, key = "'orderId='+#id")
    @Transactional(readOnly = true)
    Order get(Integer id);

    /**
     * 根据订单编号查询订单信息
     *
     * @param no
     * @return
     */
    @Cacheable(value = CACHE_KEY, key = "'orderNo='+#no")
    @Transactional(readOnly = true)
    Order getByNo(String no);

    /**
     * 根据订单编号查询订单信息
     *
     * @param order
     * @return
     */
//    @Cacheable(value = CACHE_KEY_LIST, key = "#order.hashCode()")
    @Transactional(readOnly = true)
    PageInfo<Order> list(Order order, Pageable pageable);

    /**
     * 根据创建人查询订单列表信息
     *
     * @param userId
     * @return
     */
    @Cacheable(value = CACHE_KEY_LIST)
    @Transactional(readOnly = true)
    List<Order> listByUserId(Integer userId);
}
