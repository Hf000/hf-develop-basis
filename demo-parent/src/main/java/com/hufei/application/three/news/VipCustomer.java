package com.hufei.application.three.news;


public class VipCustomer extends Customer {

    @Override
    public String sefInfo() {
        return "给VIP客户发消息，客户名字：" + super.getName() + ",客户手机号："+super.getPhone();
    }
}
