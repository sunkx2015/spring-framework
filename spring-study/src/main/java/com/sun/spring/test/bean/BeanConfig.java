package com.sun.spring.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
	//不指定name则以method方法名作为name
	@Bean
	public Car car(){
		return new Car();
	}

	@Bean
	public Car miniCar(){
		Car car = new Car();
		car.setName("mini");
		return car;
	}

	//入参对象只有一个有参构造方法时候，会自动注入
	@Bean
	public Book book(BookLabel bl){
		bl.setPage(1);
		return new Book(bl);
	}

	//设置两个相同beanName------------
	@Bean("javaBook")
	public Book javaBook2(){
		return new Book("java Primary development");
	}

	@Primary//默认注入的第一优先级,同name,有此标则默认注入
	@Bean("javaBook")
	public Book javaBook(){
		return new Book("java Advanced development");
	}
	//------------

	//测试Autowried
	@Qualifier("miniCar")
	@Autowired
	Car car;

	@Bean
	public Car myCar(){
		return car;
	}



	@Bean
	public Book favoriteBook(BookLabel bl){
		bl.setPage(22);
		return new Book(bl);
	}
}
