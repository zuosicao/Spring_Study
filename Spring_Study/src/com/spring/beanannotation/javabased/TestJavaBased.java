package com.spring.beanannotation.javabased;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJavaBased extends UnitTestBase{
	public TestJavaBased(){
		super("classpath:spring-beanannotation.xml");
	}
	
/*	@Test
	public void testJavaB(){
		Store store = super.getBean("store");
		System.out.println(store.getClass().getName());
	}*/
	
	@Test
	public void testProperties(){
		MyDriverManager myDriverManager = super.getBean("myDriverManager");
		System.out.println(myDriverManager.getClass().getName());
	}
	
	//一起运行不会关闭容器，会两次启动容器
	@Test
	public void testScope(){
		Store store = super.getBean("stringStore");
		System.out.println(store.hashCode());
		
		Store store1 = super.getBean("stringStore");
		System.out.println(store1.hashCode());
	}
	
	@Test
	public void testG(){
		Store store = super.getBean("stringStoreTest");
	}
}