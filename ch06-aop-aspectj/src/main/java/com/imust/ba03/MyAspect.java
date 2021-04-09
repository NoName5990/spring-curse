package com.imust.ba03;


import com.imust.ba02.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * @Aspect:是aspectj框架中的注解 作用：表示当前类是切面类
 * 切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 * 位置：在类定义的上面
 */
@Aspect//表示这个类的身份的，他是切面类
public class MyAspect {
    /**
     * @Around：环绕通知，
     *  特点：
     *      1、它是功能最强的通知
     *      2、在目标方法的前后都能增强功能
     *      3、控制目标方法是否被调用执行
     *      4、修改原来的目标方法的执行结果。影响最后的结果
     * 环绕通知，等同于jdk动态代理的，InvoacationHandler接口
     *  参数：ProceedingJoinPoint就等同于Method
     *      作用：执行目标的方法
     *  返回值：就是目标方法的执行结果，可以被修改
     *  环绕通知：经常做事务，在目标之前开启事务，执行目标方法，在目标方法之后提交事务
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        String name = "";
        Object result = null;
        //获取第一个参数值方便进行if中的判断
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 1) {
            Object arg = args[0];
            name = (String)arg;
        }
        System.out.println("环绕通知：在目标方法之前，输出时间：" + new Date());
        //判断，满足条件就执行目标方法
        if ("wangwu".equals(name)) {
            result = pjp.proceed();
        }
        System.out.println("环绕通知：在目标方法之后，提交事务");
//        if (result != null) {
//            result = "Hello AspectJ AOP";
//        }
        return result;
    }
}
