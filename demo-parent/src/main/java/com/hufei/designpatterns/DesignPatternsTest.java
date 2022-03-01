package com.hufei.designpatterns;

/**
 * <p> 设计模式测试类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/11/15 21:57
 */
public class DesignPatternsTest {

    public static void main(String[] args) {
        testSingleModel();
    }

    public static void testSingleModel() {
        SingleModel singleModel = SingleModel.getInstance();
        System.out.println("你好");
    }

}
