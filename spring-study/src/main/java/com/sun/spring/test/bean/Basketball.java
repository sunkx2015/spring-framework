package com.sun.spring.test.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Primary
@Component
public class Basketball implements MyOwn {
	@Override
	public void printMyDetail() {
		System.out.println("i'm basketBall");
	}
	/**
	 * @PostConstruct属于java JSR250规范的注解，在bean初始化时候和属性赋值完成调用
	 * @PreDestroy 同属于java JSR250规范,在bean销毁时候调用
	 */
	@PostConstruct
	public void init(){
		System.out.println("basketBall init");
	}
}
