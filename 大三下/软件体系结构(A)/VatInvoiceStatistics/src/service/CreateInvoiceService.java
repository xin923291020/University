package service;

import tools.InvoiceCreateTask;

public class CreateInvoiceService
{
	public void create(String instructions)
	{
		if(instructions.equals("true"))
		{
			InvoiceCreateTask.getInvoiceCreater().setInstructions(true);
			InvoiceCreateTask.getInvoiceCreater().doTask();
		}
		else
		{
			InvoiceCreateTask.getInvoiceCreater().setInstructions(false);
		}
	}
}