package test1;

public class RedState extends AccountState
{
	public RedState(AccountState state,double balance)
	{
		this.acc = state.acc;
		this.balance = balance;
	}
	public RedState(Account account)
	{
		this.acc = account;
	}
	public void withdraw(double amount)
	{
		System.out.println(acc.getOwner() + "的用户已冻结。");
	}
}