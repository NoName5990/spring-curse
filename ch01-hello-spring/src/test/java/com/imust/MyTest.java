package com.imust;

import com.imust.service.SomeService;
import com.imust.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test01(){
        //不使用spring的主动（正转）方式
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    /**
     * spring默认创建对象的时间：在创建spring的容器时，会创建配置文件中的  所有  对象
     * spring创建对象：默认调用的是无参构造方法
     */
    @Test
    public void test02(){
//        指定spring容器创建的对象
//        1、指定使用spring配置文件的名称
        String config = "beans.xml";
//        2、创建表示spring容器的对象，ApplicationContext（就是表示spring容器），可以通过容器获取对象
//        ClassPathXmlApplicationContext:表示从类路径（target下的class中读取）中加载spring的配置文件（beans.xmel)
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//        从容器中获取某个对象，你要调用对象的方法
//        getBean（“配置文件中bean的id值”）
//        把默认的object类型改为自己的
//        SomeService service = (SomeService)ac.getBean("someService");
//        使用spring创建好的对象
//        service.doSome();

    }
//    在运行时，beans文件中的所有的对象都已经创建好了然后待命
    /**
     * 获取容器中，spring对象的信息
     */
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //执行这个的时候就已经创建好了对象，看输出结果，和他所调用的什么方法无关
        int nums = ac.getBeanDefinitionCount();
        System.out.println("spring容器中总共有"+nums+"个对象");
        //获取对象名称
        String[] names = ac.getBeanDefinitionNames();
        for (String str : names) {
            System.out.println("对象名称=" + str);
        }
    }
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date mydate = (Date) ac.getBean("mydate");
        System.out.println("Date"+mydate);
    }
}
