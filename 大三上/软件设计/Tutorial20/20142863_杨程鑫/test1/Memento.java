package test1;

class Memento
{
	private String Account;
	private String Password;
	private String TelNo;
	
	public Memento(String Account,String Password,String TelNo)
    {
    	this.Account = Account;
    	this.Password = Password;
    	this.TelNo = TelNo;
    }
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
		
	public void setTelNo(String TelNo)
	{
		this.TelNo = TelNo;
	}
}