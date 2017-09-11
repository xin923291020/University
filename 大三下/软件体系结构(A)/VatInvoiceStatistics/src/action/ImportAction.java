package action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import service.ImportService;
import tools.ApplicationContextFactory;

import com.opensymphony.xwork2.ActionSupport;


public class ImportAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public void doImport() throws IOException, FileUploadException, SQLException
	{
		ApplicationContext application = ApplicationContextFactory.getApplicationContext();;
		ImportService myImportService = (ImportService) application.getBean("myImportService");
		HttpServletRequest request = ServletActionContext.getRequest();
		myImportService.doSave(request);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
	}
}