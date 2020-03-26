package com.sun.spring.test.bean;

import org.springframework.stereotype.Component;

@Component
public class Bicycle implements MyOwn {
	@Override
	public void printMyDetail() {
		System.out.println("I'm bicycle");
	}
}
