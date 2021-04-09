package com.imust;

import com.imust.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {

    @Test
    public void test01(){
        System.out.println("=====test01======");
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

//      从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("studnet对象="+myStudent);
    }

    @Test
    public void test02(){
        System.out.println("=====test01======");
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

//      从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent2");
        System.out.println("studnet对象="+myStudent);
    }

//    获取文件对象
    @Test
    public void test03(){
        System.out.println("=====test01======");
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

//      从容器中获取对象
        File myfile = (File) ac.getBean("myfile");
        System.out.println(myfile.getName());
    }


}
