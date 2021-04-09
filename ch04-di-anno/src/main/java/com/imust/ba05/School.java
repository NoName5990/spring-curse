package com.imust.ba05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//带@的都是用的注解的方式，相比配置文件更加简单一些
@Component("mySchool")
public class School {
    @Value("北京大学")
    private String name;
    @Value("北京海淀区")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
