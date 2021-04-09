package com.imust.service.impl;

import com.imust.dao.StudentDao;
import com.imust.domain.Student;
import com.imust.service.StudentService;

import java.util.List;
/**
 * service是干嘛的？就是调用dao中的方法，并进行一些判断，也就是增删改查这些固定由dao实现，
 * service在此基础上进行事务的逻辑处理，包括判断之类的，这样可以降低耦合，判断的事交给service，
 * 到只管拿数据就行了
 */


public class StudentServiceImpl implements StudentService {

    //需要使用dao中的一些引用类型才可以实现
    private StudentDao studentDao;

    //因为是引用类型，如果不使用注解，那么就设置一个set方法进行赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    //赋完值以后就可以调用dao中的方法了（sql语句，执行的数据库中的内容）


    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
