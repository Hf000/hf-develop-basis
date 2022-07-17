package com.hufei.shop.decorator;

import com.hufei.shop.dao.ItemDao;
import com.hufei.shop.domain.Item;
import com.hufei.shop.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 19:59
*/
@Component(value = "orderMoneySum")
public class OrderMoneySum implements MoneySum{

    @Autowired
    private ItemDao itemDao;

    /****
     * 基础价格计算
     * @param order
     */
    @Override
    public void money(Order order) {
        //查询商品
        Item item = itemDao.findById(order.getItemId());

        //商品价格*购买数量
        order.setMoney(item.getPrice()*order.getNum());   //订单价格
        order.setPaymoney(item.getPrice()*order.getNum());//结算价格
    }
}
