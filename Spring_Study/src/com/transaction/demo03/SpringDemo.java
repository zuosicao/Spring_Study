package com.transaction.demo03;
/*
 * Spring Test 整合 JUnit 4 ,使用Spring的测试框架需要加入以下依赖包：
 * JUnit 4 （官方下载：http://www.junit.org/）
 * Spring Test （Spring框架中的test包）
 * Spring 相关其他依赖包
 */
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
 * 声明式事务管理方式一——测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:transaction_03.xml")
public class SpringDemo{
	@Resource(name="accountService")
	public AccountService accountService;
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}