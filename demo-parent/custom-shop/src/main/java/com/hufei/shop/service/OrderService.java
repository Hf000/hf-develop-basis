package com.hufei.shop.service;

import com.hufei.shop.domain.Order;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 20:02
*/
public interface OrderService {
    /***
     * 添加订单
     * @param order
     */
    int add(Order order);

    /***
     * 取消订单
     * @param id
     */
    void cancelOrder(String id);
}
