package com.spring.order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeanInvoker {
	//@Qualifier有两个bean，指定其中一个
	@Autowired @Qualifier("beanImplTwo")
	private BeanInterface beanInterface;
	
	@Autowired
	private List<BeanInterface> list;
	
	@Autowired
	private Map<String,BeanInterface> map;
	
	public void say(){
		//打印list中每个Bean的名称
		if(null!=list&&0!=list.size()){
			System.out.println("list....");
			for(BeanInterface bean:list){
				System.out.println(bean.getClass().getName());
			}
		}else{
			System.out.println("List<BeanInterface> list is null");
		}
		
		System.out.println();
		if(null!=map&&0!=map.size()){
			System.out.println("map....");
			//遍历map,打印key名称和value对象名
			for(Map.Entry<String, BeanInterface> entry:map.entrySet()){
				System.out.println(entry.getKey()+"  "+entry.getValue().getClass().getName());
			}
		}else{
			System.out.println("Map<String,BeanInterface> map is null");
		}
		
		//打印bean名称
		System.out.println();
		if(null!=beanInterface){
			System.out.println(beanInterface.getClass().getName());
		}else{
			System.out.println("beanInterface is null");
		}
	}
}
