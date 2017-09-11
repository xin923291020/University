package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Account MyAccount = new Account("Ñî³ÌöÎ",100);
		MyAccount.deposit(100);
		MyAccount.displayBalance();
		MyAccount.withdraw(1300);
		MyAccount.displayBalance();
		MyAccount.withdraw(100);
		MyAccount.displayBalance();
	}
}