package com.spring.beanannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionServiceImpl implements InjectionService {
	@Autowired
	private InjectionDAO injectionDAO;
	
	//构造器注入
 	//如果有构造方法，一定要定义一个空构造，不然无法自动装配得到bean实例???
	public InjectionServiceImpl(){
		
	}
	public InjectionServiceImpl(InjectionDAO injectionDAO){
		this.injectionDAO = injectionDAO;
	}

	public void save(String arg){
		//模拟业务操作
		System.out.println("service接收参数："+arg);
		arg = arg+":"+this.hashCode();
		injectionDAO.save(arg);
	}
	
	//设置注入
	public void setInjectionDAO(InjectionDAO injectionDAO) {
		this.injectionDAO = injectionDAO;
	}
}