package software;

import java.util.*;

import javax.swing.JOptionPane;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.IOException;     
import org.apache.poi.hssf.usermodel.HSSFCell;     
import org.apache.poi.hssf.usermodel.HSSFRow;     
import org.apache.poi.hssf.usermodel.HSSFSheet;     
import org.apache.poi.hssf.usermodel.HSSFWorkbook;     
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
public class ImportExcel
{
	@SuppressWarnings("resource")
	public static void insertDB(String filepath) throws IOException
	{
		boolean flag = false;
		boolean flag1 = false;
		StudentDatabaseConnection dc = null;
		
		GradeDatabaseConnection dc1 = null;
		
		String str = "";
	    String sql = "";
	    String sign = "";
	    
	    String str1 = "";
	    String sql1 = "";
	    String sign1 = "";
		
	    FileInputStream file =  new FileInputStream(filepath);
	    POIFSFileSystem POIFS = new POIFSFileSystem(file);
	    HSSFWorkbook workbook = new HSSFWorkbook(POIFS);
	    HSSFSheet sheet = workbook.getSheetAt(0);
	    HSSFRow row = null;
	    HSSFCell cell = null;
	    int totalRow = sheet.getLastRowNum();
	    
	    for(int i = 1;i < 4;i++)
	    {
	    	sign = sign+",?";
	    	
	    }
	    
	    for(int i = 1;i < 3;i++)
	    {
	    	sign1 = sign1+",?";
	    	
	    }
	    
	    sql = "insert into student values(?" + sign + ");";
	    
	    sql1 = "insert into studentgrade values(?" + sign1 + ");";
	    
		List<String> list = null;
		list = new ArrayList<String>();
		for(int i = 0;i <= totalRow;i++)
		{
			row = sheet.getRow(i);
			int j = 1;
			int k = row.getLastCellNum();
			while(j <= k)
			{
				cell = row.getCell(j-1);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				str = cell.getStringCellValue().toString();
				list.add(str);
				j++;
			}
			dc = new StudentDatabaseConnection();
			if(dc.update(sql,list) != 1)
			{
				flag = true;
			}
		}
		
		List<String> list1 = null;
		list1 = new ArrayList<String>();
		for(int i = 0;i <= totalRow;i++)
		{
			row = sheet.getRow(i);
			int j = 1;
			int k = 3;
			while(j <= k)
			{
				cell = row.getCell(j-1);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				str1 = cell.getStringCellValue().toString();
				list1.add(str1);
				j++;
			}
			dc1 = new GradeDatabaseConnection();
			if(dc1.update1(sql1,list1) != 1)
			{
				flag1 = true;
			}
		}
		
		
		Component frame = null;
		
		if(flag && flag1)
		{
			JOptionPane.showMessageDialog(frame,"导入文件成功，已跳过重复学生");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "导入文件成功");
		}
	}
}