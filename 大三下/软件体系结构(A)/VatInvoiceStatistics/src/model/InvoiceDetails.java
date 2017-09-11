package model;

public class InvoiceDetails implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String invoiceCode;
	private String serviceName;
	private String specificationModel;
	private String unit;
	private Integer number;
	private Double unitPrice;
	private Double amount;
	private Double taxRate;
	private Double tax;

	public InvoiceDetails(){}

	public InvoiceDetails(Integer id)
	{
		this.id = id;
	}

	public InvoiceDetails(Integer id,String serviceName,
			String specificationModel, String unit, Integer number,
			Double unitPrice, Double amount, Double taxRate, Double tax)
	{
		this.id = id;
		this.serviceName = serviceName;
		this.specificationModel = specificationModel;
		this.unit = unit;
		this.number = number;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.taxRate = taxRate;
		this.tax = tax;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getInvoiceCode()
	{
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode)
	{
		this.invoiceCode = invoiceCode;
	}

	public String getServiceName()
	{
		return this.serviceName;
	}

	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}

	public String getSpecificationModel()
	{
		return this.specificationModel;
	}

	public void setSpecificationModel(String specificationModel)
	{
		this.specificationModel = specificationModel;
	}

	public String getUnit()
	{
		return this.unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public Integer getNumber()
	{
		return this.number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

	public Double getUnitPrice()
	{
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public Double getAmount()
	{
		return this.amount;
	}

	public void setAmount(Double amount)
	{
		this.amount = amount;
	}

	public Double getTaxRate()
	{
		return this.taxRate;
	}

	public void setTaxRate(Double taxRate)
	{
		this.taxRate = taxRate;
	}

	public Double getTax()
	{
		return this.tax;
	}

	public void setTax(Double tax)
	{
		this.tax = tax;
	}
}