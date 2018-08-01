package com.springbasis.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.springbasis.aop")
@EnableAspectJAutoProxy //1
public class AopConfig {

}
