package com.spring.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestZscBeanName extends UnitTestBase {
	public TestZscBeanName(){
		super("classpath:spring-aware.xml");
	}
	
	@Test
	public void testZscBeanName(){
		System.out.println("TestZscBeanName:"+super.getBean("zscBeanName"));

	}
}