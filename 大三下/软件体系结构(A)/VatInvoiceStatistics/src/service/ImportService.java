package service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import model.Invoice;
import model.InvoiceDetails;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.InvoiceDao;

public class ImportService
{
	private InvoiceDao invoiceDao;
	public void doSave(HttpServletRequest request) throws FileUploadException, SQLException
	{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		if (!ServletFileUpload.isMultipartContent(request))
		{
			return;
		}
		List<FileItem> list = upload.parseRequest(request);
		try
		{
			Workbook workbook = Workbook.getWorkbook(list.get(0).getInputStream());
			for (int i = 0; i < workbook.getSheets().length; i++)
			{
				Sheet sheet = workbook.getSheet(i);
				String invoicePrefixCode = sheet.getCell(1, 1).getContents();
				String invoiceSuffixCode = sheet.getCell(3, 1).getContents();
				String invoiceCode = invoicePrefixCode + invoiceSuffixCode;
				//String billingDate = sheet.getCell(6, 1).getContents();
				String buyer = sheet.getCell(2, 2).getContents();
				String saller = sheet.getCell(2, 6).getContents();
				Double totalAmount = Double.valueOf(sheet.getCell(6, 10).getContents());
				Double totalTax = Double.valueOf(sheet.getCell(8, 10).getContents());
				Invoice invoice = new Invoice(invoiceCode,buyer,
						saller,totalAmount,totalTax);
				
				ArrayList<InvoiceDetails> invoiceDetailsArrayList = new ArrayList<InvoiceDetails>();
				DecimalFormat decimalFormat = new DecimalFormat("######0.0000");
				for(int row = 12;row < sheet.getRows();row++)
				{
					InvoiceDetails invoiceDetails = new InvoiceDetails();
					String serviceName = sheet.getCell(1, row).getContents();
					String specificationModel = sheet.getCell(2, row).getContents();
					String unit = sheet.getCell(3, row).getContents();
					Integer number = Integer.valueOf(sheet.getCell(4, row).getContents());
					Double unitPrice = Double.valueOf(sheet.getCell(5, row).getContents());
					Double amount = Double.valueOf(sheet.getCell(6, row).getContents());
					String taxRateString = sheet.getCell(7, row).getContents();
					Double taxRate = Double.valueOf(taxRateString.substring(0,taxRateString.length() - 1)) / 100;
					taxRate = Double.valueOf(decimalFormat.format(taxRate));
					Double tax = Double.valueOf(sheet.getCell(8, row).getContents());
					invoiceDetails.setInvoiceCode(invoiceCode);
					invoiceDetails.setServiceName(serviceName);
					invoiceDetails.setSpecificationModel(specificationModel);
					invoiceDetails.setUnit(unit);
					invoiceDetails.setNumber(number);
					invoiceDetails.setUnitPrice(unitPrice);
					invoiceDetails.setAmount(amount);
					invoiceDetails.setTaxRate(taxRate);
					invoiceDetails.setTax(tax);
					invoiceDetailsArrayList.add(invoiceDetails);
				}
				invoiceDao.addInvoice(invoice, invoiceDetailsArrayList);
			}
		}
		catch (BiffException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
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