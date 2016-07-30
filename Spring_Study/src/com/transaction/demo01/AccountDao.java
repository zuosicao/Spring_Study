package com.transaction.demo01;

/*
 * 转账Dao接口
 */
public interface AccountDao {
	/*
	 * out转出账号
	 * in转入账号
	 * money转账金额
	 */
	public void outMoney(String out,Double money);
	public void inMoney(String in,Double money);
}
