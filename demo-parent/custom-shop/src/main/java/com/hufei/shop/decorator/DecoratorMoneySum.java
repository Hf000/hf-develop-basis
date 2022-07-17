package com.hufei.shop.decorator;

import com.hufei.shop.domain.Order;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 20:00
*/
public abstract class DecoratorMoneySum implements MoneySum {

    //被扩展的对象
    private MoneySum moneySum;

    public void setMoneySum(MoneySum moneySum) {
        this.moneySum = moneySum;
    }

    //价格计算
    @Override
    public void money(Order order) {
        moneySum.money(order);
    }
}
