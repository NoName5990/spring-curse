package com.imust.ba01;

public class Student {


    private String name;
    private Integer age;
    //spring是先调用构造再执行set方法
    public Student(){
        System.out.println("调用了无参构造方法！");
    }

    public void setEmail(String email) {
        System.out.println("email="+email);
    }

//    在spring中使用property语句完成设值注入需要有set方法，spring只是执行了setXXX方法
    public void setName(String name) {
        this.name = name;
        this.name = name.toUpperCase();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
