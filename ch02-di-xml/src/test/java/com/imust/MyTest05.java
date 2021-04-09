package com.imust;

import com.imust.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {

    @Test
    public void test01(){
        System.out.println("=====test01======");
        String config = "ba05/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

//      从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("studnet对象="+myStudent);
    }




}
