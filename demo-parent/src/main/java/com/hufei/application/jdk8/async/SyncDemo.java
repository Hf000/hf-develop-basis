package com.hufei.application.jdk8.async;

import java.util.Random;

public class SyncDemo {

    static Random random = new Random();

    //接收文章名称，计算出文章的分数
    public static int getArticleScore(String aName){

        int a = calculateArticleScore(aName);

        int b = calculateArticleScore(aName);

        int c = calculateArticleScore(aName);

        //其他业务处理
        doSomeThings();

        //返回文章分数
        return a+b+c;

    }

    private static void doSomeThings() {
        System.out.println("do some things");
    }

    //计算文章分数
    private static int calculateArticleScore(String aName) {
        //模拟延迟
        otherService();
        return random.nextInt(100);
    }

    private static void otherService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        System.out.println(getArticleScore("demo"));
    }
}
