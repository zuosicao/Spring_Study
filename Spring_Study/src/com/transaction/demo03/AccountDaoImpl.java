package com.transaction.demo03;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/*
 * 转账Dao实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
	/*
	 * out转出账号
	 * in转入账号
	 * money转账金额
	 */
	public void outMoney(String out,Double money){
		String sql = "update account set money = money-? where name = ?";
		this.getJdbcTemplate().update(sql,money,out);
	}
	
	public void inMoney(String in,Double money){
		String sql = "update account set money = money+? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
	}
}
