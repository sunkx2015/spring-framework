package com.sun.spring.test.main;

import com.sun.spring.test.service.ObjInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudySource {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ObjInterface obj = (ObjInterface) aca.getBean("c");
		obj.hello();
		System.out.println("run ok");
	}
}
