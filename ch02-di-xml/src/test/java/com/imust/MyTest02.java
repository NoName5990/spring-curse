package com.imust;

import com.imust.ba02.School;
import com.imust.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {

    @Test
    public void test01(){
        System.out.println("=====test01======");
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("studnet对象="+myStudent);
    }


    @Test
    public void test02(){
        System.out.println("=====test02======");

        Student student =new Student();
        student.setName("lisi");
        student.setAge(20);

        School school = new School();
        school.setName("内蒙古科技大学");
        school.setAddress("内蒙古包头市昆都仑区阿尔丁大街");
        student.setSchool(school);
        System.out.println("student====="+student);
    }

}
