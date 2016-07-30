package com.spring.beanscope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase {
	public TestBeanScope(){
		super("classpath:spring-beanscope.xml");
	}
	/*
	 * 在同一个方法中，得到的是同一个对象
	 * singleton 一个容器只创建一次
	 * prototype每次请求都会创建新实例
	 */
	@Test
	public void testSay(){
		BeanScope beanScope = super.getBean("beanScope");
		beanScope.say();
		
		BeanScope beanScope1 = super.getBean("beanScope");
		beanScope1.say();

	}
	
	/*
	 * 同一次执行中，在不同的方法中得到的是不同的对象
	 * 因为test注释的方法每次执行都要重新加载一次容器，所以是从不同的容器加载的类
	 */
	@Test
	public void testSay1(){
		BeanScope beanScope = super.getBean("beanScope");
		beanScope.say();
	}
}