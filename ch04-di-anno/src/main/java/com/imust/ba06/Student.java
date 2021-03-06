package com.imust.ba06;


import org.springframework.beans.factory.annotation.Value;//来自spring框架
import org.springframework.stereotype.Component;//来自spring框架

import javax.annotation.Resource;//来自于jdk

@Component("myStudent")
public class Student {

    @Value("虚竹")
    private String name;
    private Integer age;

    /**
     * 引用类型
     * @Resources：来自jdk中的注解，spring框架中提供了对这个注解的功能支持，可以使用它给应用类型赋值
     *      使用的也是来自注入的原理，支持nyName、byType，默认是byName
     *  位置：
     *      1、在属性定义的上面，无需set方法，推荐使用
     *      2、在set方法的上面
     */
    @Resource
    private School school;

    public Student(){
        System.out.println("=====调用了无参构造放方法=====");

    }

    public void setName(String name) {
        this.name = name;
    }

    @Value("30")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
