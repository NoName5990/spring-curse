package com.imust.ba02;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Aspect:是aspectj框架中的注解 作用：表示当前类是切面类
 * 切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 * 位置：在类定义的上面
 */
@Aspect//表示这个类的身份的，他是切面类
public class MyAspect {
    /**
     * 后置定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     *      1、公共方法public
     *      2、方法没有返回值
     *      3、方法名称自定义
     *      4、方法有参数的，推荐使用Object，参数名是自定义的
     */
    /**
     * @AfterReturning:后置通知 属性：
     * 1、value 切入点表达式
     * 2、returniing自定义的变量，表示目标方法的返回值
     * 自定义变量名必须和通知方法的形参名一样
     * 特点：
     * 1、在目标之后执行
     * 2、能获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
     *  Object res = doOther(); returnning代表的是返回值，可以根据返回值做自己的事情，并且是自动返回的
     * 3、可以修改返回值
     *
     *
     * 后置通知的执行
     *      Object res = doOther();
     *      myAfterReturning(res);
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "res1")
    public void myAfterReturning(Object res1) {
        System.out.println("后置通知，获得的返回值是："+res1);
        //修改目标方法的返回值,看是否会影响最后的方法调用结果
        if (res1 != null) {
            res1 = "hello Aspectj!";
        }
    }


    @AfterReturning(value = "execution(* *..SomeServiceImpl.doStudent(..))", returning = "res")
    public void myAfterReturning2(Object res) {
        System.out.println("后置通知，获得的返回值是："+res);
        //修改目标方法的返回值,看是否会影响最后的方法调用结果
        if (res != null) {
            Student st = new Student();
            st.setAge(19);
            st.setName("nihao");
            res=st;
        }
    }
}
