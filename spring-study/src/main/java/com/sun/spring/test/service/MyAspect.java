package com.sun.spring.test.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 1.在配置类上启动Aspect:@EnableAspectJAutoProxy
 * 2.在切面类定义本类为Aspect
 * 3.定义切入点:joinPoint
 * 4.定义切入的时机和执行的动作
 *
 * 注意一定要加Component，让spring扫描到
 */
@Aspect
@Component
public class MyAspect {

	//第一种写法，直接在切入时机上写需要监听的切入面(访问权限 返回类型 位置)
	@Before("execution(public double com.sun.spring.test.service.MyService.*(int,int))")
	public void befor(JoinPoint joinPoint){
		System.out.println(joinPoint.getThis().getClass()+"param:"+getStrs(joinPoint.getArgs()));
	}

	private String getStrs(Object [] objs){
		String str="";
		for(Object obj : objs){
			str+=obj+",";
		}
		return str;
	}

}
