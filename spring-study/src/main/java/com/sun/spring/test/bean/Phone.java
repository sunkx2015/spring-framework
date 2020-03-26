package com.sun.spring.test.bean;

import org.springframework.stereotype.Component;

/**
 * 测试spring扫描规则：在自动扫描路径下，如果没有标识是组件还是config等注解，spring是不会放到容器的
 */
public class Phone {

	public Phone() throws Exception {
		throw  new Exception("no cache");
	}
}
