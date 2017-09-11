package tools;

import java.util.Timer;
import java.util.TimerTask;

public class InvoiceCreateTask
{
	private static InvoiceCreateTask invoiceCreaterTask = null;
	private static boolean instructions = false;
	private static Timer timer = new Timer();
	public static InvoiceCreateTask getInvoiceCreater()
	{
		if(invoiceCreaterTask == null)
		{
			invoiceCreaterTask = new InvoiceCreateTask();
		}
		return invoiceCreaterTask;
	}
	
	public void doTask()
	{
		timer.schedule(new TimerTask()
		{
			public void run()
			{
				if(instructions)
				{
					InvoiceCreater.doCreate();
				}
				else
				{
					timer.cancel();
				}
			}
		},0,1000);
	}
	
	public void setInstructions(boolean instructions)
	{
		InvoiceCreateTask.instructions = instructions;
	}
}
