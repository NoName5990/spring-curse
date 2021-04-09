package com.imust;

import com.imust.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取对象
        SomeService someService = (SomeService) ctx.getBean("someService");
        String st = someService.doFirst("wangwu", 23);
        System.out.println("st=="+st);
    }

}
