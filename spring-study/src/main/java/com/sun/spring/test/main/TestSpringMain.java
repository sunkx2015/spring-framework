package com.sun.spring.test.main;

import com.sun.spring.test.bean.Book;
import com.sun.spring.test.bean.BookLabel;
import com.sun.spring.test.bean.Car;
import com.sun.spring.test.config.SpringStartConfig;
import com.sun.spring.test.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringMain {
	public static void main(String[] args) {
		//ApplicationContext
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		/**
		 * 打印所有bean
		 * spring初始化后只有spring的bean在容器里
		 * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		 * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		 * org.springframework.context.annotation.internalCommonAnnotationProcessor
		 * org.springframework.context.event.internalEventListenerProcessor
		 * org.springframework.context.event.internalEventListenerFactory
		 */
		printBeans(annotationConfigApplicationContext);
		/**
		 * 3种扫描方式
		 * 1.context.scan("传入扫描的包，数组")
		 * 2.context.register(App.class)
		 * ****这样做后一定要调用refresh方法来刷新容器，否则bean到不了容器
		 * 3.new AnnotationConfigApplicationContext(传入App.class)
		 * ****构造方法里自己调用了refresh方法
		 * **
		 */
		//方法一:扫描自己的包
		//annotationConfigApplicationContext.scan(new String[]{"com.sun.spring.test.bean"});
		//方法二:指定configClass,@Configuration来指定了扫描路径
		annotationConfigApplicationContext.register(SpringStartConfig.class);
		//刷新容器
		annotationConfigApplicationContext.refresh();
		//
		printBeans(annotationConfigApplicationContext);
		//===============================================
		/**
		 * spring的bean是单例的,测试bean属性变化
		 * 1.不同对象注入相同的bean,其中一个bean属性变化，其他对象的属性也变
		 * 以下为证明，打印出来的bean是同一个，page属性的值也一样
		 */
//		BookLabel bookLabel = (BookLabel)annotationConfigApplicationContext.getBean("bookLabel");
//		Book book = (Book)annotationConfigApplicationContext.getBean("book");
//		Book favoriteBook = (Book)annotationConfigApplicationContext.getBean("favoriteBook");
//		System.out.println("spring context book bean:"+bookLabel+",page:"+bookLabel.getPage());
//		System.out.println("book bean:"+book.getBookLabel()+",page:"+book.getBookLabel().getPage());
//		System.out.println("favoriteBook book bean:"+favoriteBook.getBookLabel()+",page:"+book.getBookLabel().getPage());
		//===============================================
		/**
		 * spring的beanName是唯一的，测试两个相同beanName
		 * 1.相同的beanName，后实例的不入容器
		 */
//		Book book = (Book)annotationConfigApplicationContext.getBean("javaBook");
//		//Book book2 = (Book)annotationConfigApplicationContext.getBean("javaBook2");
//		System.out.println(book.getName());
//		//System.out.println(book2.getName());

		/**
		 * 测试Qualifier
		 */
//		Car car = (Car)annotationConfigApplicationContext.getBean("myCar");
//		System.out.println(car.getName());

		/**
		 * 测试@Primary
		 */
		MyService myService = (MyService)annotationConfigApplicationContext.getBean("myService");
		myService.sayHello();
	}

	private static void printBeans(AnnotationConfigApplicationContext context){
		System.out.println("========print beans S======");
		String[] strs = context.getBeanDefinitionNames();
		for(String str : strs){
			System.out.println(str);
		}
		System.out.println("========print beans E======");
	}
}
