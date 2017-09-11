package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import service.CreateInvoiceService;
import tools.ApplicationContextFactory;

import com.opensymphony.xwork2.ActionSupport;

public class CreateInvoiceAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	public void doCreate() throws IOException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();;
		CreateInvoiceService myCreateInvoiceService = (CreateInvoiceService) application.getBean("myCreateInvoiceService");
		HttpServletRequest request = ServletActionContext.getRequest();
		String instructions = request.getParameter("instructions");
		myCreateInvoiceService.create(instructions);
	}
}