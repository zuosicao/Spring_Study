package com.spring.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("bean")
public class BeanAnnotation {
	public void say(String arg){
		System.out.println("BeanAnnotation"+this.hashCode());
	}
}

