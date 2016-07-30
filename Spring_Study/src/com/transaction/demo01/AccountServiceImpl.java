package com.transaction.demo01;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService{
	/*
	 * out转出账号
	 * in转入账号
	 * money转账金额
	 */
	private AccountDao accountDao;
	
	
	private TransactionTemplate transactionTemplate;
	
	
	//内部类中不能直接使用外部类中的变量，需要定义为final的变量？？？
	public void transfer(final String out,final String in,final Double money){
		transactionTemplate.execute(new TransactionCallbackWithoutResult(){
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				// TODO Auto-generated method stub
				accountDao.outMoney(out, money);
				//执行时出异常
				int d = 1/0; 
				accountDao.inMoney(in, money);
			}
		
		});
		
		/*
		 * 不加事务会先减了，但是没加。
		 
		accountDao.outMoney(out, money);
		//执行时出异常
		int d = 1/0; 
		accountDao.inMoney(in, money);
		*/
	}
	
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}


	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}


}