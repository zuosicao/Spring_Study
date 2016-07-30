package com.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ZscBeanName implements BeanNameAware,ApplicationContextAware{
	private ApplicationContext applicationContext;
	private String beanName;
	@Override
	public void setBeanName(String name){
		this.beanName = name;
		System.out.println("zsc:"+name);
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException{
		this.applicationContext = applicationContext;
		System.out.println(applicationContext.getBean(beanName));
	}
}
