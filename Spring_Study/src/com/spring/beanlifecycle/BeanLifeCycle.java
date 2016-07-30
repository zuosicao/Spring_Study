package com.spring.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle implements InitializingBean,DisposableBean{
	//实现InitializingBean接口，初始化覆写afterPropertiesSet()
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean接口初始化");
	};
		
	//实现DisposableBean接口，销毁bean，覆写destroy()
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean接口销毁");
	};
		
	//xml中配置init-method="start" 
	public void start(){
		System.out.println("start");
	}
		
	//xml中配置destroy-method="stop"，设置scope为prototype时不会执行stop方法
	public void stop(){
		System.out.println("stop");
	}
}
