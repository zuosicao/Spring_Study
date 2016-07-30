package com.spring.beanannotation;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionDAOImpl implements InjectionDAO{
	public void save(String arg){
		//模拟保存数据
		System.out.println("save data"+arg); 
	}
}