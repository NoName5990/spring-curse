package com.imust;

import com.imust.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService buyService = (BuyGoodsService) ctx.getBean("buyService");
        System.out.println("service是代理：" + buyService.getClass().getName());
        buyService.buy(1001,1000);
    }
}
