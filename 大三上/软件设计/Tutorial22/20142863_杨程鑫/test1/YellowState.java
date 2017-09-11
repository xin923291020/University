package test1;

public class YellowState extends AccountState
{
	public YellowState(AccountState state,double balance)
	{
		this.acc = state.acc;
		this.balance = balance;
	}
	public YellowState(Account account)
	{
		this.acc = account;
	}
}