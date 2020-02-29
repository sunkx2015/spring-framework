package org.springframework.test.debug;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.service.ObjInterface;

public class StudySource {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		ObjInterface obj = (ObjInterface) aca.getBean("c");
//		obj.hello();
		System.out.println("run ok");
	}
}
