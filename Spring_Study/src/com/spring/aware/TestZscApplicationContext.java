package com.spring.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestZscApplicationContext extends UnitTestBase {
	public TestZscApplicationContext(){
		super("classpath:spring-aware.xml");
	}
	
	@Test
	public void testZscApplicationContext(){
		System.out.println("testZscApplicationContext:"+super.getBean("zscApplicationContext").hashCode());

	}
}
