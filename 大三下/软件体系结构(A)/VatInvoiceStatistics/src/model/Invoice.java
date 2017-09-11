package model;

public class Invoice implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String invoiceCode;
	private String buyer;
	private String seller;
	private Double totalAmount;
	private Double totalTax;

	public Invoice(){}

	public Invoice(String invoiceCode)
	{
		this.invoiceCode = invoiceCode;
	}

	public Invoice(String invoiceCode, String buyer,
			String seller, Double totalAmount, Double totalTax)
	{
		this.invoiceCode = invoiceCode;
		this.buyer = buyer;
		this.seller = seller;
		this.totalAmount = totalAmount;
		this.totalTax = totalTax;
	}

	public String getInvoiceCode()
	{
		return this.invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode)
	{
		this.invoiceCode = invoiceCode;
	}

	public String getBuyer()
	{
		return this.buyer;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
	}

	public String getSeller()
	{
		return this.seller;
	}

	public void setSeller(String seller)
	{
		this.seller = seller;
	}

	public Double getTotalAmount()
	{
		return this.totalAmount;
	}

	public void setTotalAmount(Double totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public Double getTotalTax()
	{
		return this.totalTax;
	}

	public void setTotalTax(Double totalTax)
	{
		this.totalTax = totalTax;
	}
}