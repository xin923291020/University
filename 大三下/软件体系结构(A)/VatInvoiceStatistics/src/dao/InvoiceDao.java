package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Invoice;
import model.InvoiceDetails;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import tools.ApplicationContextFactory;
import tools.DateTool;

public class InvoiceDao
{
	private SessionFactory sessionFactory;

	public InvoiceDao()
	{
		super();
	}

	public boolean addInvoice(Invoice invoice,
			ArrayList<InvoiceDetails> invoiceDetailsArrayList)
			throws SQLException
	{
		boolean isSuccess = false;
		try
		{
			String sql = "insert into Invoice" + DateTool.getSuffixDate()
					+ " values(?,?,?,?,?)";
			PreparedStatement preparedStatement = ApplicationContextFactory
					.getPreparedStatement(sql);
			preparedStatement.setString(1, invoice.getInvoiceCode());
			preparedStatement.setString(2, invoice.getBuyer());
			preparedStatement.setString(3, invoice.getSeller());
			preparedStatement.setString(4, invoice.getTotalAmount().toString());
			preparedStatement.setString(5, invoice.getTotalTax().toString());
			preparedStatement.execute();

			sql = "insert into InvoiceDetails" + DateTool.getSuffixDate()
					+ " values(?,?,?,?,?,?,?,?,?)";
			preparedStatement = ApplicationContextFactory
					.getPreparedStatement(sql);
			for (int i = 0; i < invoiceDetailsArrayList.size(); i++)
			{
				preparedStatement.setString(1, invoiceDetailsArrayList.get(i)
						.getInvoiceCode());
				preparedStatement.setString(2, invoiceDetailsArrayList.get(i)
						.getServiceName());
				preparedStatement.setString(3, invoiceDetailsArrayList.get(i)
						.getSpecificationModel());
				preparedStatement.setString(4, invoiceDetailsArrayList.get(i)
						.getUnit());
				preparedStatement.setString(5, invoiceDetailsArrayList.get(i)
						.getNumber().toString());
				preparedStatement.setString(6, invoiceDetailsArrayList.get(i)
						.getUnitPrice().toString());
				preparedStatement.setString(7, invoiceDetailsArrayList.get(i)
						.getAmount().toString());
				preparedStatement.setString(8, invoiceDetailsArrayList.get(i)
						.getTaxRate().toString());
				preparedStatement.setString(9, invoiceDetailsArrayList.get(i)
						.getTax().toString());
				preparedStatement.execute();
			}
			isSuccess = true;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Invoice> getTotalAmountByMonth(String year, int month,
			boolean inOrOut)
	{

		try
		{
			List<Invoice> ls = new ArrayList<Invoice>();
			String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES Where TABLE_NAME like 'invoice_"
					+ year + "_";
			if (month >= 1 && month <= 9)
			{
				sql += "0" + month + "%'";
			} else
			{
				sql += month + "%'";
			}
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			while (rs.next())
			{
				String currentTable = rs.getString(1);
				Session session = sessionFactory.getCurrentSession();
				String hql = "";
				if (inOrOut)
				{
					hql = "select * from " + currentTable
							+ " Where seller = '石家庄铁道大学超市'";
				} else
				{
					hql = "select * from " + currentTable
							+ " Where seller != '石家庄铁道大学超市'";
				}
				List<Invoice> list = session.createSQLQuery(hql)
						.addEntity(Invoice.class).list();
				if (list.size() != 0)
				{
					ls.addAll(list);
				}
			}
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Invoice> getTotalAmountByYear(int year, boolean inOrOut)
	{

		try
		{
			List<Invoice> ls = new ArrayList<Invoice>();
			String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES Where TABLE_NAME like 'invoice_"
					+ year + "%'";
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			while (rs.next())
			{
				String currentTable = rs.getString(1);
				Session session = sessionFactory.getCurrentSession();
				String hql = "";
				if (inOrOut)
				{
					hql = "select * from " + currentTable
							+ " Where seller = '石家庄铁道大学超市'";
				} else
				{
					hql = "select * from " + currentTable
							+ " Where seller != '石家庄铁道大学超市'";
				}
				List<Invoice> list = session.createSQLQuery(hql)
						.addEntity(Invoice.class).list();
				if (list.size() != 0)
				{
					ls.addAll(list);
				}
			}
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Invoice> getTotalAmountByQuarter(String year, int quarter,
			boolean inOrOut)
	{
		try
		{
			List<Invoice> ls = new ArrayList<Invoice>();
			String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES Where ";
			String tablePrefix = "invoice_" + year;
			if (quarter == 0)
			{
				sql += "TABLE_NAME like '" + tablePrefix
						+ "_03%' or TABLE_NAME like '" + tablePrefix
						+ "_04%' or TABLE_NAME like '" + tablePrefix + "_05%'";
			} else if (quarter == 1)
			{
				sql += "TABLE_NAME like '" + tablePrefix
						+ "_06%' or TABLE_NAME like '" + tablePrefix
						+ "_07%' or TABLE_NAME like '" + tablePrefix + "_08%'";
			} else if (quarter == 2)
			{
				sql += "TABLE_NAME like '" + tablePrefix
						+ "_09%' or TABLE_NAME like '" + tablePrefix
						+ "_10%' or TABLE_NAME like '" + tablePrefix + "_11%'";
			} else
			{
				sql += "TABLE_NAME like '" + tablePrefix
						+ "_12%' or TABLE_NAME like '" + tablePrefix
						+ "_01%' or TABLE_NAME like '" + tablePrefix + "_02%'";
			}
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			while (rs.next())
			{
				String currentTable = rs.getString(1);
				Session session = sessionFactory.getCurrentSession();
				String hql = "";
				if (inOrOut)
				{
					hql = "select * from " + currentTable
							+ " where seller = '石家庄铁道大学超市'";
				} else
				{
					hql = "select * from " + currentTable
							+ " where seller != '石家庄铁道大学超市'";
				}
				List<Invoice> list = session.createSQLQuery(hql)
						.addEntity(Invoice.class).list();
				if (list.size() != 0)
				{
					ls.addAll(list);
				}
			}
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Invoice> getTotalAmountByTimeStamp(String beforeTime,
			String afterTime, boolean inOrOut)
	{
		try
		{
			List<Invoice> ls = new ArrayList<Invoice>();
			Session session = sessionFactory.getCurrentSession();
			String hql = "";
			if (inOrOut)
			{
				hql = "select * from invoice" + DateTool.getSuffixDate()
						+ " Where seller = '石家庄铁道大学超市' And createTime < '"
						+ DateTool.getDate() + " " + afterTime + "' And createTime > '"
						+ DateTool.getDate() + " " + beforeTime + "'";
			} else
			{
				hql = "select * from invoice" + DateTool.getSuffixDate()
						+ " Where seller != '石家庄铁道大学超市' And createTime < '"
						+ DateTool.getDate() + " " + afterTime + "' And createTime > '"
						+ DateTool.getDate() + " " + beforeTime + "'";
			}
			List<Invoice> list = session.createSQLQuery(hql)
					.addEntity(Invoice.class).list();
			if (list.size() != 0)
			{
				ls.addAll(list);
			}
			return ls;
		} catch (HibernateException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public double getIncomeOrExpenditure(boolean isToday,boolean inOrOut)
	{
		double totalAmountCount = 0;
		double totalTaxCount = 0;
		try
		{
			String sql = "select sum(totalAmount),sum(totalTax) from invoice";
			if(isToday)
			{
				sql += DateTool.getSuffixDate();
			}
			else
			{
				sql += DateTool.getYesterdaySuffixDate();
			}
			if(inOrOut)
			{
				sql += " where seller = '石家庄铁道大学超市'";
			}
			else
			{
				sql += " where seller != '石家庄铁道大学超市'";
			}
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			System.out.println(sql);
			rs.next();
			totalAmountCount = Double.valueOf(rs.getString(1));
			totalTaxCount = Double.valueOf(rs.getString(2));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return totalAmountCount + totalTaxCount;
	}
	
	public String getOfftakeOrPurchase(boolean inOrOut)
	{
		String result = "分析出错";
		String sql = "";
		try
		{
			if(inOrOut)
			{
				sql += "select COUNT(seller),buyer from invoice" + DateTool.getSuffixDate();
				sql += " where seller = '石家庄铁道大学超市'";
				sql += " group by buyer order by COUNT(seller) DESC";
			}
			else
			{
				sql += "select COUNT(seller),seller from invoice" + DateTool.getSuffixDate();
				sql += " where buyer = '石家庄铁道大学超市'";
				sql += " group by seller order by COUNT(seller) DESC";
			}
			ResultSet rs = ApplicationContextFactory.getResultSet(sql);
			rs.next();
			result = rs.getString(2);
		}
		catch (SQLException e)
		{
			System.out.println(sql);
			e.printStackTrace();
		}
		return result;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
}