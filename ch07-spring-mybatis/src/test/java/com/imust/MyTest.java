package com.imust;

import com.imust.dao.StudentDao;
import com.imust.domain.Student;
import com.imust.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[] = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象的名称："+name+"|"+ctx.getBean(name));
        }
    }

    @Test
    public void testDaoInsert() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student(1013, "周峰", "zhoufeng@qq.com", 20);
        int nums = dao.insertStudent(student);
        System.out.println("nums="+nums);
    }
    @Test
    public void testServiceInsert() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student = new Student(1014, "齐御风", "qiyufeng@qq.com", 20);
        int nums = studentService.addStudent(student);
        //spring和mybatis整合时，事务是自动提交的，无需执行SqlSession.commit()
        System.out.println("nums="+nums);
    }

    @Test
    public void testServiceSelect() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student stu : students) {
            System.out.println("sutdent:"+stu);
        }
    }

}
