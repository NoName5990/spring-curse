package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.dao.impl.UserDaoImpl;
import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    //引用类型， 在xml文件给属性赋值， 要求属性需要有set方法
    //有一种不需要set方法的赋值是简单类型的赋值，用的是@Value
    @Autowired//用引用类型的赋值方式，自动给UserDao引用类型对象进行赋值
    @Qualifier("mysqlDao")
    private UserDao dao = null;

    //可以不需要，
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        //处理数据，调用dao的方法
        //调用dao的方法
        dao.insertUser(user);
    }
}
