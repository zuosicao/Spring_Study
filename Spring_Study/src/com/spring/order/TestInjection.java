package com.spring.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase{
	public TestInjection(){
		super("classpath:spring-order.xml");
	}
	
	@Test
	public void testMultiBean(){
		//getBean里面是填 bean的id不是bean的名称
		BeanInvoker invoker = super.getBean("beanInvoker");
		invoker.say();
	}
}