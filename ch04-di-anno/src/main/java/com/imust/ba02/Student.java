package com.imust.ba02;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Value:简单类型的属性赋值
 *  属性：value是String类型的，表示简单类型的属性值
 *  位置：1、在属性定义的上面，无需set方法，推荐使用
 *       2、在set方法的上面（很少使用）
 */
@Component("myStudent")
public class Student {
    @Value("虚竹")
    private String name;
    @Value("22")
    private Integer age;

    public Student(){
        System.out.println("=====调用了无参构造放方法=====");

    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
