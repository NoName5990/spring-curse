package com.imust.service.impl;

import com.imust.service.SomeService;
import com.imust.util.ServiceTools;

/**
 * 如何实现在不修改service类的代码的前提下，也能够增加 输出时间，事务？
 *  --动态代理：
 *      动态代理是可以在不修改原来代码的前提下增加功能的【重要】
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome!");
    }

    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther！");
    }
}
