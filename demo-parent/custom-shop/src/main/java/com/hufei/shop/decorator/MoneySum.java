package com.hufei.shop.decorator;

import com.hufei.shop.domain.Order;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:59
*/
public interface MoneySum {

    /***
     * 订单价格[结算]运算
     */
    void money(Order order);

}
