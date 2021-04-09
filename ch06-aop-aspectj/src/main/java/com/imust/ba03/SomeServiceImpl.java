package com.imust.ba03;


//目标类
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, Integer age) {
        //此方法就是业务方法

        //给doSome这个方法增加一个功能，在doSome（）执行之前，输出方法的执行时间
        System.out.println("=======目标方法doSome()=======");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("=======目标方法doOther()=======");
        return "abcd";
    }



    @Override
    public String doFirst(String name, Integer gae) {
        System.out.println("=====执行了doFirst（）方法=======");
        return "doFirst";
    }
}
