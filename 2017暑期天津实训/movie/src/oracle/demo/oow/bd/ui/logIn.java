package oracle.demo.oow.bd.ui;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.demo.oow.bd.dao.CustomerDAO;
import oracle.demo.oow.bd.to.CustomerTO;

public class logIn extends HttpServlet
{
	private static final long serialVersionUID = 5588228310165178112L;
	private String loginPage = "login.jsp";
	private String indexPage = "index.jsp";

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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean useMoviePosters = request.getParameter("useMoviePosters") == null ? false : true;

		CustomerDAO customerDAO = new CustomerDAO();
		CustomerTO customerTO = customerDAO.getCustomerByCredential(username, password);
		Date date = new Date();

		if (customerTO != null)
		{

			// Delete all the previous ratings of the customers from the
			// DB
			//����oracle�е����ݣ�connδ��ʼ�������ض�
			//custRatingDAO.deleteCustomerRating(customerTO.getId());

			/////// ACTIVITY ////////����activity��û������movieId��δִ�����������䡣
			/*ActivityTO activityTO = new ActivityTO();
			activityTO.setActivity(ActivityType.LOGIN);
			activityTO.setCustId(customerTO.getId());
			ActivityDAO aDAO = new ActivityDAO();
			aDAO.insertCustomerActivity(activityTO);

			activityTO.setActivity(ActivityType.LIST_MOVIES);
			aDAO.insertCustomerActivity(activityTO);*/

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("time", date);
			session.setAttribute("userId", customerTO.getId());
			session.setAttribute("name", customerTO.getName());
			session.setAttribute("useMoviePosters", useMoviePosters);

			// Ashok
			//System.out.println(" setting session and redirecting " + activityTO.toJsonString());
			response.sendRedirect(indexPage);

		} else
		{
			response.sendRedirect(loginPage + "?error=1");
		}

	}
}
