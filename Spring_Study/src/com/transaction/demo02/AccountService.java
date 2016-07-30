package com.transaction.demo02;

public interface AccountService {
	/*
	 * out转出账号
	 * in转入账号
	 * money转账金额
	 */
	public void transfer(String out,String in,Double money);
}
