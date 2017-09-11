package model;

public class Account implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String taxpayerNumber;
	private String account;
	private String password;
	private String registrationTime;

	public Account(){}

	public Account(String taxpayerNumber)
	{
		this.taxpayerNumber = taxpayerNumber;
	}

	public Account(String taxpayerNumber,String account,
			String password, String registrationTime)
	{
		this.taxpayerNumber = taxpayerNumber;
		this.account = account;
		this.password = password;
		this.registrationTime = registrationTime;
	}

	public String getTaxpayerNumber()
	{
		return this.taxpayerNumber;
	}

	public void setTaxpayerNumber(String taxpayerNumber)
	{
		this.taxpayerNumber = taxpayerNumber;
	}

	public String getAccount()
	{
		return this.account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRegistrationTime()
	{
		return this.registrationTime;
	}

	public void setRegistrationTime(String registrationTime)
	{
		this.registrationTime = registrationTime;
	}
}