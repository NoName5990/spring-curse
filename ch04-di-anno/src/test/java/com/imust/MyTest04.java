package com.imust;


import com.imust.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
//        Student myStudent = (Student) ac.getBean("student");
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("student="+myStudent);
    }

}
