package com.hufei.design.patterns.behavioral.strategy;


public class StrategyTest {

    public static void main(String[] args) {
        //创建对象实例
        OrderMoney orderMoney = new OrderMoney();
        //获取指定策略
        Strategy strategy = StrategyFactory.get(3);
        //设置策略
        orderMoney.setStrategy(strategy);

        //执行计算[基于不同策略计算]
        Integer money = orderMoney.moneySum(1000);
        System.out.println(money);
    }
}
