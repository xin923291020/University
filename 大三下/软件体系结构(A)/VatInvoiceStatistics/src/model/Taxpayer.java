package model;

public class Taxpayer implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String taxpayerNumber;
	private String idNumber;
	private String taxpayerName;
	private String address;
	private String phone;

	public Taxpayer(){}

	public Taxpayer(String taxpayerNumber)
	{
		this.taxpayerNumber = taxpayerNumber;
	}

	public Taxpayer(String taxpayerNumber, String idNumber,
			String taxpayerName, String address, String phone)
	{
		this.taxpayerNumber = taxpayerNumber;
		this.idNumber = idNumber;
		this.taxpayerName = taxpayerName;
		this.address = address;
		this.phone = phone;
	}

	public String getTaxpayerNumber()
	{
		return this.taxpayerNumber;
	}

	public void setTaxpayerNumber(String taxpayerNumber)
	{
		this.taxpayerNumber = taxpayerNumber;
	}

	public String getIdNumber()
	{
		return this.idNumber;
	}

	public void setIdNumber(String idNumber)
	{
		this.idNumber = idNumber;
	}

	public String getTaxpayerName()
	{
		return this.taxpayerName;
	}

	public void setTaxpayerName(String taxpayerName)
	{
		this.taxpayerName = taxpayerName;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}