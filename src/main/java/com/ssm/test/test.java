package com.ssm.test;


import com.ssm.model.User;
import com.ssm.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserService userService = (UserService) ac.getBean("userService");

        User user=userService.getUser("buyer","37254660e226ea65ce6f1efd54233424");

        System.out.print(user.toString());
    }
}