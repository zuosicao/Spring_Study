package com.transaction.demo02;
/*
 * 声明式事务管理方式一，需要使用AOP
 * AOP使用的jar有两个
 * spring-aop-3.2.0.RELEASE.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 */
public class AccountServiceImpl implements AccountService{
	/*
	 * out转出账号
	 * in转入账号
	 * money转账金额
	 */
	private AccountDao accountDao;
	
	public void transfer(String out, String in, Double money) {
		// TODO Auto-generated method stub
		accountDao.outMoney(out, money);
//		int d = 1/0;
		accountDao.inMoney(in, money);
	}

	
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
}
