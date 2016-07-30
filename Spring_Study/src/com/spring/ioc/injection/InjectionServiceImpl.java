package com.spring.ioc.injection;

public class InjectionServiceImpl implements InjectionService {
	private InjectionDAO injectionDAO;
	
	//构造器注入
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
	public static void main(String[] args){
		
	}
}