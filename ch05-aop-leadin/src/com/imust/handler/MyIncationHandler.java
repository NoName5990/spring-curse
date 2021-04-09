package com.imust.handler;

import com.imust.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {
    /**
     * 这里要注意的一点是，因为对象是动态的，所以要创建一个接受的，用Object可以接受任何class
     */
    //目标对象
    private Object target;//待会这传进来的是SomeServiceImpl类

    //通过构造方法来接收传入的class
    public MyIncationHandler(Object target) {
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用这个invoke()
        System.out.println("执行MyIncationHandler中的invoke方法");
        Object res = null;
        System.out.println(method);
        ServiceTools.doLog();//方法执行前加的，顺序一致
        //执行目标类方法，通过Method类实现
        res = method.invoke(target, args);//通过接受的class传入到method.invoke方法中的第一参数，就是doOther/doSoem方法
        ServiceTools.doTrans();//方法执行后加的，顺序一致
        //目标方法执行结果
        System.out.println(res);
        return res;
    }
}
