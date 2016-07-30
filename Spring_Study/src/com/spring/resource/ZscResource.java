package com.spring.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class ZscResource implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException{
		this.applicationContext = applicationContext;
	}
	
	public void resource() throws IOException{
		Resource resource = applicationContext.getResource("https://www.baidu.com/s?wd=加try%20catch%20%20快捷键%20%20myeclipse&rsv_spt=1&rsv_iqid=0x9ab146c4000bdc0c&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&oq=%25E5%258A%25A0try%2520catch%2520%25E5%25BF%25AB%25E6%258D%25B7%25E9%2594%25AE&rsv_t=1efaMycfdeFfInc%2Br4osysR%2BFxHnjTQoSYwqggP%2F3zj2cXWLw91T5YZWZLIz8yxDi2YL&inputT=3820&rsv_sug3=45&rsv_pq=e3daff98000ac974&rsv_sug2=0&rsv_sug4=3942");
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
	}
}
