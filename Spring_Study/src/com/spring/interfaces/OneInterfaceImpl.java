package com.spring.interfaces;

public class OneInterfaceImpl implements OneInterface {
	@Override
	public String hello(String word){
		return "OneInterfaceImpl"+word;
	}
}
