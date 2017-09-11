package test1;

public abstract class AccountState
{
	protected Account acc;
	protected double balance;
	public void stateCheck()
	{
		if(balance >= 0)
		{
			acc.setState(new GreenState(this,balance));
		}
		else if(balance < 0 && balance >= -1000)
		{
			acc.setState(new YellowState(this,balance));
		}
		else
		{
			acc.setState(new RedState(this,balance));
		}
	}
	public void deposit(double amount)
	{
		balance += amount;
		System.out.println(acc.getOwner() + "存钱:" + amount);
		stateCheck();
	}
	public void withdraw(double amount)
	{
		balance -= amount;
		System.out.println(acc.getOwner() + "取钱:" + amount);
		stateCheck();
	}
	public void displayBalance()
	{
		System.out.println(acc.getOwner() + "的账户余额为" + balance);
	}
}