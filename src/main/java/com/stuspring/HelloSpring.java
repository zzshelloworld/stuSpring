package com.stuspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangzhe17848
 */
@Component
public class HelloSpring {
    private final static Logger LOGGER = LoggerFactory.getLogger(HelloSpring.class);

    @PostConstruct
    public void start() {
        LOGGER.info("annotationBean start");
    }

    @PreDestroy
    public void destroy() {
        LOGGER.info("annotationBean destroy");
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 3 : Hello ! " + name);
    }
}

