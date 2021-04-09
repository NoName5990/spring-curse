package com.imust.ba04;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /**
     * 引用类型
     * @Autowired：spring框架提供的注解，实现引用类型的赋值
     * spring中通过注解给引用类型赋值，使用的是自动注入原理，支持byName，byType
     *  @Autowired：默认使用的是byType自动注入
     *      位置：
     *          1）在属性定义的上main，无需set方法，推荐使用
     *          2）在set的方法上面
     *  如果不想使用默认的，要使用byName的方式，需要做的是：
     *      1、在属性上面加入@Autowired（表示自动注入）
     *      2、在属性上面加入@Qualifier（value=“bean的id”）：表示使用指定名称的bean完成赋值（表示找名字）
     *          一般value=的都可以省略
     */
//    byName自动注入
    @Autowired
    @Qualifier("mySchool")
    private School school;

    public Student(){
        System.out.println("=====调用了无参构造放方法=====");

    }

    public void setName(String name) {
        this.name = name;
    }

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
