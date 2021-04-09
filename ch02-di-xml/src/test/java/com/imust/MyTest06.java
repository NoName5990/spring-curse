package com.imust;

import com.imust.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {

    @Test
    public void test01(){
        //加载得是主文件，并从主文件中获取包含的文件
        System.out.println("=====================================================test=====================================================");
        String config = "ba06/total.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

//      从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("studnet对象="+myStudent);
        System.out.println();
    }

}
