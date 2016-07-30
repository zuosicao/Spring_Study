package com.spring.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjectServiceAnnotation extends UnitTestBase {
	public TestInjectServiceAnnotation(){
		super("classpath:spring-beanannotation.xml");
	}
	
	@Test
	public void testInjectServiceAnnotation(){
		InjectionServiceImpl service = super.getBean("injectionServiceImpl");
		service.save("this is annotation");
	}
}
