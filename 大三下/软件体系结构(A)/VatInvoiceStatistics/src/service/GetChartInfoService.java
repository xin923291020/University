package service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import model.Invoice;
import dao.InvoiceDao;

public class GetChartInfoService
{
	private InvoiceDao invoiceDao;
	public String getChartInfoInOneYear(String year,String kind)
	{
		JSONArray totalAmountJsonArray = new JSONArray();
		JSONObject inTotalAmountJsonObject = new JSONObject();
		JSONObject outTotalAmountJsonObject = new JSONObject();
		if(kind.equals("0"))
		{
			String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			for(int i = 1;i < 13;i++)
			{
				double totalAmount = 0;
				double taxAmount = 0;
				List<Invoice> ls = invoiceDao.getTotalAmountByMonth(year,i,true);
				for(int j = 0;j < ls.size();j++)
				{
					totalAmount += ls.get(j).getTotalAmount();
					taxAmount += ls.get(j).getTotalTax();
				}
				inTotalAmountJsonObject.put(month[i - 1],String.valueOf(totalAmount + taxAmount));
			}
			for(int i = 1;i < 13;i++)
			{
				double totalAmount = 0;
				double taxAmount = 0;
				List<Invoice> ls = invoiceDao.getTotalAmountByMonth(year,i,false);
				for(int j = 0;j < ls.size();j++)
				{
					totalAmount += ls.get(j).getTotalAmount();
					taxAmount += ls.get(j).getTotalTax();
				}
				outTotalAmountJsonObject.put(month[i - 1],String.valueOf(totalAmount + taxAmount));
			}
			totalAmountJsonArray.add(inTotalAmountJsonObject);
			totalAmountJsonArray.add(outTotalAmountJsonObject);
		}
		else if(kind.equals("1"))
		{
			String[] month = {"One","Two","Three","Four"};
			for(int i = 0;i < 4;i++)
			{
				double totalAmount = 0;
				double taxAmount = 0;
				List<Invoice> ls = invoiceDao.getTotalAmountByQuarter(year,i,true);
				for(int j = 0;j < ls.size();j++)
				{
					totalAmount += ls.get(j).getTotalAmount();
					taxAmount += ls.get(j).getTotalTax();
				}
				inTotalAmountJsonObject.put(month[i],String.valueOf(totalAmount + taxAmount));
			}
			for(int i = 0;i < 4;i++)
			{
				double totalAmount = 0;
				double taxAmount = 0;
				List<Invoice> ls = invoiceDao.getTotalAmountByQuarter(year,i,false);
				for(int j = 0;j < ls.size();j++)
				{
					totalAmount += ls.get(j).getTotalAmount();
					taxAmount += ls.get(j).getTotalTax();
				}
				outTotalAmountJsonObject.put(month[i],String.valueOf(totalAmount + taxAmount));
			}
			totalAmountJsonArray.add(inTotalAmountJsonObject);
			totalAmountJsonArray.add(outTotalAmountJsonObject);
		}
		return totalAmountJsonArray.toJSONString();
	}
	
	public String getChartInfoInManyYear(String startYear,String finishYear)
	{
		int start = Integer.valueOf(startYear);
		int finish = Integer.valueOf(finishYear);
		JSONArray totalAmountJsonArray = new JSONArray();
		JSONObject inTotalAmountJsonObject = new JSONObject();
		JSONObject outTotalAmountJsonObject = new JSONObject();
		for(int i = start;i <= finish;i++)
		{
			double totalAmount = 0;
			double taxAmount = 0;
			List<Invoice> ls = invoiceDao.getTotalAmountByYear(i,true);
			for(int j = 0;j < ls.size();j++)
			{
				totalAmount += ls.get(j).getTotalAmount();
				taxAmount += ls.get(j).getTotalTax();
			}
			inTotalAmountJsonObject.put(String.valueOf(i),String.valueOf(totalAmount + taxAmount));
		}
		for(int i = start;i <= finish;i++)
		{
			double totalAmount = 0;
			double taxAmount = 0;
			List<Invoice> ls = invoiceDao.getTotalAmountByYear(i,false);
			for(int j = 0;j < ls.size();j++)
			{
				totalAmount += ls.get(j).getTotalAmount();
				taxAmount += ls.get(j).getTotalTax();
			}
			outTotalAmountJsonObject.put(String.valueOf(i),String.valueOf(totalAmount + taxAmount));
		}
		totalAmountJsonArray.add(inTotalAmountJsonObject);
		totalAmountJsonArray.add(outTotalAmountJsonObject);
		return totalAmountJsonArray.toJSONString();
	}
	
	public String getChartByCurrentTime(String times)
	{
		JSONArray jsonArray = JSON.parseArray(times);
		JSONArray totalAmountJsonArray = new JSONArray();
		for(int i = 0;i < jsonArray.size() - 1;i++)
		{
			JSONObject jsonObject = new JSONObject();
			double totalAmount = 0;
			double taxAmount = 0;
			List<Invoice> ls = invoiceDao.getTotalAmountByTimeStamp(jsonArray.get(i).toString(),jsonArray.get(i + 1).toString(),true);
			for(int j = 0;j < ls.size();j++)
			{
				totalAmount += ls.get(j).getTotalAmount();
				taxAmount += ls.get(j).getTotalTax();
			}
			jsonObject.put("In",String.valueOf(totalAmount + taxAmount));
			
			totalAmount = 0;
			taxAmount = 0;
			ls = invoiceDao.getTotalAmountByTimeStamp(jsonArray.get(i).toString(),jsonArray.get(i + 1).toString(),false);
			for(int j = 0;j < ls.size();j++)
			{
				totalAmount += ls.get(j).getTotalAmount();
				taxAmount += ls.get(j).getTotalTax();
			}
			jsonObject.put("Out",String.valueOf(totalAmount + taxAmount));
			totalAmountJsonArray.add(jsonObject);
		}
		return totalAmountJsonArray.toJSONString();
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