package com.hufei.designpatterns.singleton;

/**
 * <p> 单例模式 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/11/15 21:40
 */
public class SingleModel {

    /**
     * 定义一个私有的单例类声明变量, 使用volatile关键字保证对所有线程的可见性, 并防止jvm重排指令
     */
    private static volatile SingleModel singleModel = null;

    /**
     * 私有化构造
     */
    private SingleModel() {}

    /**
     * 提供静态方法, 获取当前类实例
     * @return 返回单例对象
     */
    public static SingleModel getInstance() {
        //判空处理，保证唯一, 防止多线程阻塞, 影响系统性能
        if (null == singleModel) {
            //加锁
            synchronized (SingleModel.class) {
                //保证临界点的创建实例的唯一
                if (null == singleModel) {
                    //创建实例对象
                    singleModel = new SingleModel();
                }
            }
        }
        return singleModel;
    }

}
