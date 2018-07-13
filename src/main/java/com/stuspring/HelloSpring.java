package com.stuspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhangzhe17848
 */
@Component
public class HelloSpring {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloSpring.class);

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 3 : Hello ! " + name);
    }
}

