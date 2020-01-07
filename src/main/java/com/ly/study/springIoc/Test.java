package com.ly.study.springIoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {


    @GetMapping("/testIOC")
    public String testIOC() throws Exception {

        MyBeanFactoryImpl beanFactory = new MyBeanFactoryImpl();

        User user1 = (User)beanFactory.getBeanByName("com.ly.study.springIoc.User");
        User user2 = (User)beanFactory.getBeanByName("com.ly.study.springIoc.User");
        Student student1 = user1.getStudent();
        Student student2 = user1.getStudent();
        Student student3 = (Student)beanFactory.getBeanByName("com.ly.study.springIoc.Student");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        return "OK";


    }
}
