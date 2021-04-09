package com.imust;

import com.imust.handler.MyIncationHandler;
import com.imust.service.SomeService;
import com.imust.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {
    public static void main(String[] args) {
//        //调用doSome和doOther
//        SomeService service = new SomeServiceImpl();
//        service.doSome();
//        System.out.println("==============================");
//        service.doOther();


//        使用jdk的Proxy创建代理对象
//        1、创建目标对象
        SomeService target = new SomeServiceImpl();
//        2、创建InvocationHandler对象
        InvocationHandler handler = new MyIncationHandler(target);
//       3、使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
//        通过代理执行方法啊，会调用handler中的invoke()
        proxy.doSome();
    }
}
