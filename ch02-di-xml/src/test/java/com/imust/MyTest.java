package com.imust;

import com.imust.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test01(){
        String config = "ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//        从容器中获取Studnet对象
        Student myStudnet = (Student) ac.getBean("myStudent");
        System.out.println("student对象="+myStudnet);

        Date myDate = (Date) ac.getBean("mydata");
        System.out.println("mydate="+myDate);
    }
}
