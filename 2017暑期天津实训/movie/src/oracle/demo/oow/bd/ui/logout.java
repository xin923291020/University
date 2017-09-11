package oracle.demo.oow.bd.ui;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import oracle.demo.oow.bd.dao.ActivityDAO;
import oracle.demo.oow.bd.pojo.ActivityType;
import oracle.demo.oow.bd.to.ActivityTO;

public class logout extends HttpServlet
{
	private static final long serialVersionUID = 8612257184205867560L;
	private String loginPage = "login.jsp";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession();
			if (!session.isNew())
			{
				int userId = (Integer) request.getSession().getAttribute("userId");
				ActivityTO activityTO = new ActivityTO();
				activityTO.setActivity(ActivityType.LOGIN);
				activityTO.setCustId(userId);
				ActivityDAO aDAO = new ActivityDAO();
				aDAO.insertCustomerActivity(activityTO);

				session.invalidate();
				session = request.getSession();
			}
			response.sendRedirect(loginPage);
		} catch (Exception e)
		{
			response.sendRedirect(loginPage);
		}
	}
}
