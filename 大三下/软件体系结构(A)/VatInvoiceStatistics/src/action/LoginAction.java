package action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import service.AccountService;
import tools.ApplicationContextFactory;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Account account;
	
	public void doLogin() throws IOException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();;
		AccountService myAccountService = (AccountService) application.getBean("myAccountService");
		HttpServletResponse response = ServletActionContext.getResponse();
		if(myAccountService.isLoginSuccess(account.getAccount(),account.getPassword()))
		{
			response.getWriter().print("true");
		}
		else
		{
			response.getWriter().print("false");
		}
	}

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}
	
}