package test1;

public class UserInfoDTO
{
	private String Account;
	private String Password;
	private String TelNo;
	
	public String GetAccount()
	{
		return Account;
	}
	
	public void SetAccount(String Account)
	{
		this.Account = Account;
	}

	public String GetPassword()
	{
		return Password;
	}
	
	public void SetPassword(String Password)
	{
		this.Password = Password;
	}
	
	public String GetTelNo()
	{
		return TelNo;
	}
	
	public void SetTelNo(String TelNo)
	{
		this.TelNo = TelNo;
	}
		
	public Memento saveMemento()
	{
		return new Memento(Account,Password,TelNo);
	}
	
	public void restoreMemento(Memento Memento)
	{
		this.Account = Memento.GetAccount();
		this.Password = Memento.GetPassword();
		this.TelNo = Memento.GetTelNo();
	}
	
	public void show()
	{
		System.out.println("Account:" + this.Account);
		System.out.println("Password:" + this.Password);
		System.out.println("TelNo:" + this.TelNo);		
	}
}