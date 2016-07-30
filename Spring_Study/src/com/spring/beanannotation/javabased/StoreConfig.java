package com.spring.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * @Configuration等价 与XML中配置beans,@Bean标注方法等价于XML中配置bean,不是spring，java自带
 */
@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {
	/*
	 * @Autowired和@Bean都可以写在字段和setter方法上，不要同时出现，都是注入
	 * @Autowired是由spring提供，默认byType,允许null,可以设置required为false
	 * @Autowired @Qualifier("stringStore") 按名称
	 */
	@Autowired @Qualifier("stringStore")
	private Store<String> s1;
	
	@Autowired @Qualifier("integerStore")
	private Store<Integer> s2;
	
	/*
	 * 读取资源文件,资源文件是iso-8895-1编码的？？？写不进中文
	 */
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.url}")
	private String url;
	
	//注意username需要加前缀  比如jdbc.username不然会取到操作系统的登录名
	@Value("${jdbc.username}")
	private String userName;
	
	@Bean
	public MyDriverManager myDriverManager(){
		return new MyDriverManager(password,url,userName);
	}
	
	/*
	 * 默认返回的bean的id为方法名称，还可以自己指定名称@Bean(name="foo")
	 * @Bean(name="store",initMethod="init",destroyMethod="destroy")
	 * 
	 * 默认为单例singleton，prototype每次创建新实例
	 * @Scope(value="prototype",proxyMode=ScopedProxyMode.TARGET_CLASS),proxyMode了解下就好
	 */
	@Bean(name="stringStore",initMethod="init",destroyMethod="destroy") @Scope(value="prototype",proxyMode=ScopedProxyMode.TARGET_CLASS)
	public StringStore stringStore(){
		return new StringStore();
	}
	
	@Bean(name="integerStore")
	public IntegerStore integerStore(){
		return new IntegerStore();
	}
	
	@Bean(name="stringStoreTest")
	public Store stringStoreTest(){
		System.out.println("s1"+s1.getClass().getName());
		System.out.println("s2"+s2.getClass().getName());
		return new StringStore();
	}
}