package com.imust.ba01;


import org.springframework.stereotype.Component;

/**
 * @Component：创建对象的，等同于<bean>的功能
 *  属性：value 就是对象的名称，也就是bean的id值
 *      value的值是唯一的，创建的对象在整个spring容器中就一个
 *  位置：在类的上面，创建完后放在容器之中
 *      @Component(value = "myStudent")等同于
 *      <bean id="myStudent" class="com.imust.ba01.Student"/>
 *
 *      spring中和@Component功能一致，创建对象的注解有：
 *          1、@Repository（用在持久层类上）：放在dao实现类上面，表示创建dao对象，dao对象是能访问数据库的
 *          2、@Service（用在业务层类上）：放在service的实现类上面，创建service对象，service对象是做业务处理，
 *              可以有事务等功能的
 *          3、@Controller（用在控制器类上）：放在控制器（处理器）类的上面，创建控制器对象
 *              控制器对象：能够接受用户提交的参数，显示请求处理结果，servlet功能
 *      以上3个注解的使用语法和@Component是一样的，都能创建对象，但是这3个注解还有额外的功能。
 *      @Repository，@Service，@Controller是给项目的对象分层的（拥有@Component的基本功能，并且也有自己特殊的功能）。
 *      当不知道类是哪一个的时候，用 @Component 的就行，如果清楚知道是那一层就用哪一个
 */
//使用value属性来指定对象名称
//Component(value="myStudent")
//可以省略valeu


@Component("myStudent")
/**
 * @Component
 * 不指定对象名称，由spring提供默认名称
 *      是类名的首字母小写
 */
//@Component
public class Student {
    private String name;
    private Integer age;

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
                '}';
    }
}
