package com.sun.spring.test.service;

import com.sun.spring.test.bean.MyOwn;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;

/**
 * 获取spring容器Context
 * 方法一:继承ApplicatioObjectSupport重写initApplicationContext
 * 方法二:实现ApplicationContextAware
 */
@Service
public class MyService //extends ApplicationObjectSupport
		implements ApplicationContextAware  {
	//private ApplicationContext context;
	private ApplicationContext context;
	/**
	 * 此时注入，有两个子类实现，spring不知道注入哪个，方法有二
	 * 1.子类添加默认注解@Primary
	 * 2.指定注入的名字@Qualifier
	 */
	@Qualifier("bicycle")
	@Autowired
	MyOwn myOwn;

	//也可以在method方法上通过Qualifier标识对象
	public void sayHello(){
		System.out.println("myService ====================");
		myOwn.printMyDetail();
		String[] myOwn = context.getBeanNamesForType(MyOwn.class);
		for(String my : myOwn){
			System.out.println(my);
		}
		System.out.println("myService E====================");
	}

	public double divNum(int i,int y){
		System.out.println(i/y);
		return i/y;
	}

//	@Override
//	protected void initApplicationContext(ApplicationContext context) throws BeansException {
//		this.context = context;
//		String[] myOwn = context.getBeanNamesForType(MyOwn.class);
//		for(String my : myOwn){
//			System.out.println(my);
//		}
//	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
}
