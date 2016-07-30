package com.transaction.demo03;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * 声明式事务管理方式三，基于注解的方式
 * 配置文件开启注解事务后，哪个业务类使用事务就加@Transactional注解即可
 * 
 * @Transactional注解属性,不写为默认值
 * 	propagation事务传播行为 
 * 	isolation事务隔离级别
 *	readOnly只读(不能进行修改、删除、插入操作)
 *	rollbackFor发生哪些异常回滚事务
 *	noRollbackFor发生哪些异常不回滚事务
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
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
		//int d = 1/0;
		accountDao.inMoney(in, money);
	}

	
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
}

