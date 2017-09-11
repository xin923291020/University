package service;

import java.text.NumberFormat;

import net.sf.json.JSONObject;

import dao.InvoiceDao;

public class AnalysisService
{
	private InvoiceDao invoiceDao;
	
	public JSONObject getAnalysisResult()
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("income",getIncomeIncrease());
		jsonObject.put("expenditure",getExpenditureIncrease());
		jsonObject.put("offtake",getOfftake());
		jsonObject.put("purchase",getPurchase());
		System.out.print(jsonObject.toString());
		return jsonObject;
	}
	
	private String getIncomeIncrease()
	{
		double incomeToday = invoiceDao.getIncomeOrExpenditure(true, true);
		double incomeYesterday = invoiceDao.getIncomeOrExpenditure(false, true);
		NumberFormat numberFormat = NumberFormat.getPercentInstance();  
		numberFormat.setMaximumFractionDigits(2);
		return numberFormat.format((incomeToday - incomeYesterday) / incomeYesterday);
	}
	
	private String getExpenditureIncrease()
	{
		double expenditureToday = invoiceDao.getIncomeOrExpenditure(true, false);
		double expenditureYesterday = invoiceDao.getIncomeOrExpenditure(false, false);
		NumberFormat numberFormat = NumberFormat.getPercentInstance();  
		numberFormat.setMaximumFractionDigits(2);
		return numberFormat.format((expenditureToday - expenditureYesterday) / expenditureYesterday);
	}
	
	private String getOfftake()
	{
		return invoiceDao.getOfftakeOrPurchase(true);
	}
	
	private String getPurchase()
	{
		return invoiceDao.getOfftakeOrPurchase(false);
	}

	public InvoiceDao getInvoiceDao()
	{
		return invoiceDao;
	}

	public void setInvoiceDao(InvoiceDao invoiceDao)
	{
		this.invoiceDao = invoiceDao;
	}
}