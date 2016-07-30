package com.spring.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanAnnotation extends UnitTestBase {
	public TestBeanAnnotation(){
		super("classpath:spring-beanannotation.xml");
	}
	

	@Test
	public void testBeanAnnotation(){
		BeanAnnotation beanAnnotation = super.getBean("bean");
		beanAnnotation.say("zsc");
		
		BeanAnnotation beanAnnotation1 = super.getBean("bean");
		beanAnnotation1.say("zsc");
	}
}
