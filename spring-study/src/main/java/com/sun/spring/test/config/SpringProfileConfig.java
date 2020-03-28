package com.sun.spring.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan(value = {"com.sun.spring.test"})
public class SpringProfileConfig {

}
