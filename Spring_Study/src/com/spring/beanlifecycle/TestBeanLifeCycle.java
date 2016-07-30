package com.spring.beanlifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifeCycle extends UnitTestBase {
	public TestBeanLifeCycle(){
		super("classpath:spring-lifecycle.xml");
	}
	
	@Test
	public void testLifeCycle(){
		super.getBean("beanLifeCycle");

	}
}