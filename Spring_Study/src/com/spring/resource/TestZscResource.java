package com.spring.resource;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.spring.test.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestZscResource extends UnitTestBase {
	public TestZscResource(){
		super("classpath:spring-resource.xml");
	}
	
	@Test
	public void setTestZscResource(){
		ZscResource zscResource = super.getBean("zscResource");
		
		try {
			zscResource.resource();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}