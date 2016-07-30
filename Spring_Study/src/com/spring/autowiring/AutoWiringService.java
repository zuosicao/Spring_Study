package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringService {
	private AutoWiringDAO autoWiringDAO;

	public AutoWiringService(AutoWiringDAO autoWiringDAO){
		System.out.println("AutoWiringService constructor");
		this.autoWiringDAO = autoWiringDAO;
	}
	public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
		this.autoWiringDAO = autoWiringDAO;
	}
	public void say(String word){
		this.autoWiringDAO.say(word);
	}
	
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-autowiring.xml");
		AutoWiringService autoWiringService = (AutoWiringService)context.getBean("autoWiringService");
		autoWiringService.say("1111");
		
	}
}
