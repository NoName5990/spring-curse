package com.imust.ba01;


import org.aspectj.lang.JoinPoint;
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
     * 定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     *      1、公共方法public
     *      2、方法没有返回值
     *      3、方法名称自动以
     *      4、方法可以有参数，也可以没有参数
     *          如果有参数，参数不是自定义的，有几个类型的参数可以使用（选择）。
     */
    /**
     * @Before：前置通知注解
     *  属性：value，是切入点表达式，表示切面的功能执行的位置。
     *  位置：在方法的上面
     *  特点：
     *      1、目标方法前执行
     *      2、不改变目标方法
     *      3、不影响目标方法执行
     * 下方的代码表示在public void com.imust.ba01.SomeServiceImpl.doSome(String, Integer)方法（位置excution）前（时间@Before）
     * 执行myBefore方法（功能）
     */
//    时间、位置、功能三要素
//    @Before(value = "execution( public void com.imust.ba01.SomeServiceImpl.doSome(String, Integer))")//完整的语法名
//    //时间             位置
//    public void myBefore() {
//        //就是切面要执行的功能
//        //@Before注解时间，表示在方法的前面执行
//        System.out.println("前置通知，切面功能，方法执行前输出时间："+new Date());
//        //功能
//    }
    //简化写法：

//    @Before(value = "execution(void com.imust.ba01.SomeServiceImpl.doSome(String, Integer))")
////    public void myBefore() {
////        System.out.println("==========1============前置通知，切面功能，方法执行前输出时间："+new Date());
////    }

//    @Before(value = "execution(void *..SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore() {
//        System.out.println("========2============前置通知，切面功能，方法执行前输出时间："+new Date());
//    }
//    @Before(value = "execution(* *..SomeServiceImpl.doSome(..))")
//    public void myBefore() {
//        System.out.println("========3============前置通知，切面功能，方法执行前输出时间："+new Date());
//    }
//    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
//    public void myBefore() {
//        System.out.println("========4============前置通知，切面功能，方法执行前输出时间："+new Date());
//    }

    /**
     * 指定通知方法中的参数：JoinPoinr（连接点）
     * JointPoint：业务方法，要加入切面功能的业务方法（此处业务方法是doSome(String,Integer),
     * 作用是：可以在通知方法中获取方法执行的信息，例如方法名，方法的参数
     * 如果你的切面功能中需要用到方法的信息，就加入JoinPoint
     * 这个JoinPoint参数的值是由框架赋予的，必须是第一个位置的参数
     */
    @Before(value = "execution(void *..SomeServiceImpl.doSome(String, Integer))")
    public void myBefore(JoinPoint jp) {
//        System.out.println("========5============前置通知，切面功能，方法执行前输出时间："+new Date());
        System.out.println("输出签名:" + jp.getSignature());
        System.out.println("输出名字：" + jp.getSignature().getName());
        System.out.println("输出参数：");
        Object[] args = jp.getArgs();
        for (Object ob : args) {
            System.out.println("参数="+ob);
        }

    }


}
