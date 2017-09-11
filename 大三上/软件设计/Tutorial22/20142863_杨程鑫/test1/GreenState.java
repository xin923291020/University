package test1;

public class GreenState extends AccountState
{
	public GreenState(AccountState state,double balance)
	{
		this.acc = state.acc;
		this.balance = balance;
	}
	public GreenState(Account account)
	{
		this.acc = account;
	}
}