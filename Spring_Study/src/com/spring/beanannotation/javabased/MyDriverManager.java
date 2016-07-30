package com.spring.beanannotation.javabased;

public class MyDriverManager {
	private String password;
	private String url;
	private String username;
	public MyDriverManager(String password,String url,String username){
		System.out.println("url : " + url);
		System.out.println("userName: " + username);
		System.out.println("password: " + password);
	}
}
