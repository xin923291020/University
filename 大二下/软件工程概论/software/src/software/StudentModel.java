package software;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.*; 

public class StudentModel extends AbstractTableModel
{
	private static final long serialVersionUID = 2417450566011836338L;
	Vector<String> cloumn;
	@SuppressWarnings("rawtypes")
	Vector<Vector> row;
	Object[][] data;
	ResultSet rs;
	StudentDatabaseConnection dc;
	TableColumn TableColumn;
	@SuppressWarnings("rawtypes")
	public void queryStudent(String sqlStr,String[] args)
	{    
		cloumn = new Vector<String>();
		cloumn.add("学号");
		cloumn.add("班级");
		cloumn.add("姓名");
		cloumn.add("博客地址");
		
		row = new Vector<Vector>();
		dc = new StudentDatabaseConnection();
		rs = dc.query(sqlStr,args);   
		try
		{ 
			while (rs.next())
			{
				Vector<String> hang = new Vector<String>();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				row.add(hang);
			}
		}    
		catch(Exception ex)
		{
			ex.printStackTrace();  //输出出错信息   
		}
		dc.close();
	}
	public boolean deleteStudent(String sql,String[] args)
	{
		dc = new StudentDatabaseConnection();
		return dc.deleteFromSQL(sql,args);
	}
	
	@Override
	public int getColumnCount()
	{
		return this.cloumn.size();
	}
	@Override
	public int getRowCount()
	{
		return this.row.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return this.row.get(rowIndex).get(columnIndex);
	}
	@Override
	public String getColumnName(int index)
	{
		return this.cloumn.get(index);
	}	
}