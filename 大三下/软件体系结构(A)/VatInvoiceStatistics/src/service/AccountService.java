package service;

import model.Account;
import dao.AccountDao;

public class AccountService
{
	private AccountDao accountDao;
	
	public boolean isLoginSuccess(String accountId,String password)
	{
		Account account = accountDao.getAccountByAccount(accountId);
		if(account.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}

	public AccountDao getAccountDao()
	{
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	}
	
}