package com.stuspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        final ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        final HelloSpring obj = (HelloSpring) context.getBean("helloSpring");
        obj.printHello();
    }

}
