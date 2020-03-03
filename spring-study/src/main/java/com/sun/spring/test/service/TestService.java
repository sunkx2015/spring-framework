package com.sun.spring.test.service;

import org.springframework.stereotype.Service;

@Service(value = "c")
public class TestService implements ObjInterface {
	public TestService(){
		System.out.println("----init test service");
	}
	public void hello(){
		System.out.println("TestService.hello");
	};
	public String hi(){
		return "TestService.hi";
	}
}
