package com.imust;

import com.imust.ba02.SomeService;
import com.imust.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        Student student = proxy.doStudent("lisi", 20);
        System.out.println("student====="+student);
        //但是无影响啊，说明给的是副本
    }

}
