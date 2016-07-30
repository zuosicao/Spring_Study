package com.spring.interfaces;

public class Main {
	public static void main(String[] args){
		OneInterface oi = new OneInterfaceImpl();
		System.out.println(oi.hello("zsc"));
	}
}
