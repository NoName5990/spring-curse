package com.imust.util;

import java.util.Date;

/**
 * 工具类：
 * 把一些重复的东西放进来，进行封装
 * 使得原有的业务类不是那么混乱复杂
 */
public class ServiceTools {

    //用静态的原因是可以用类直接调用方法了，而不用创建实体对象了
    public static void doLog() {
        System.out.println("非业务方法，方法执行时间："+new Date());
    }

    public static void doTrans() {
        System.out.println("非业务方法，执行完毕后，提交事务！");
    }
}
