package com.spring.autowiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

/*
 * 问题二，@RunWith这个注解有什么作用？
 * 回答：Junit4的默认runner为BlockJunit4ClassRunner
 * 但是Junit4包括第三方软件还提供很多其他的runner，这样如果，我们想让我们的测试类用专门的runner来运行，这时候就可以用@RunWith(Suit.class
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoWiring extends UnitTestBase{
	public TestAutoWiring(){
		super("classpath:spring-autowiring.xml");
	}
	
	@Test
	public void setTestAutoWiring(){
		AutoWiringService autoWiringService = super.getBean("autoWiringService");
		autoWiringService.say("this is a test");
	}
}
