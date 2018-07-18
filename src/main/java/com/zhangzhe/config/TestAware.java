package com.zhangzhe.config;

import com.zhangzhe.aware.AwareService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class TestAware {
    public static void main (String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService service = context.getBean(AwareService.class);
        service.outputResult();
        context.close();
    }
}
