package com.imust.service.impl;

import com.imust.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl(){
        System.out.println("无参构造方法，对象创建的时候就已创建了！");
    }
    @Override
    public void doSome() {
        System.out.println("执行了SomeService的doSome方法！");
    }
}
