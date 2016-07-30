package com.spring.beanannotation.javabased;

public class StringStore implements Store<String>{
	
	public void init(){
		System.out.println("container start");
	}
	
	public void destroy(){
		System.out.println("container destroy");
	}
}
