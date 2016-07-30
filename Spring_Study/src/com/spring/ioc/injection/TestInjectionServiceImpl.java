package com.spring.ioc.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjectionServiceImpl extends UnitTestBase{
	public TestInjectionServiceImpl(){
		super("classpath:spring-injection.xml");
	}
	
	@Test
	public void testSetter(){
		InjectionService injectionService = super.getBean("injectionService");
		injectionService.save("这是要保存的数据");
	}
}
