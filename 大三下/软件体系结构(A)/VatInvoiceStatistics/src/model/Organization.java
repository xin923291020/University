package model;

public class Organization implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
	private String organizationCode;
	private String organizationName;
	private String address;
	private String phone;

	public Organization(){}

	public Organization(Integer id)
	{
		this.id = id;
	}

	public Organization(Integer id,String type,
			String organizationCode, String organizationName, String address,
			String phone)
	{
		this.id = id;
		this.type = type;
		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.address = address;
		this.phone = phone;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getOrganizationCode()
	{
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode)
	{
		this.organizationCode = organizationCode;
	}

	public String getOrganizationName()
	{
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName)
	{
		this.organizationName = organizationName;
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