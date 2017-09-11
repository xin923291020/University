package software;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match
{
	public static boolean isLegal(String str)
	{  
		Pattern p = Pattern.compile("(\\d{8})|([пе]\\d{4}[-]\\d{1}[╟Ю])|[\u4e00-\u9fa5]{2,4}$");
		Matcher m = p.matcher(str);   
		return m.matches();  
	}
	public static boolean isSno(String str)
	{  
		Pattern p = Pattern.compile("(\\d{8})$");
		Matcher m = p.matcher(str);   
		return m.matches();  
	}
	public static boolean isClass(String str)
	{  
		Pattern p = Pattern.compile("([пе]\\d{4}[-]\\d{1}[╟Ю])$");
		Matcher m = p.matcher(str);   
		return m.matches();  
	}
	public static boolean isAddress(String str)
	{  
		Pattern p = Pattern.compile("[http://www.cnblogs.com/]\\[abcdefghijklmnopqrstuvwxyz]{0,100}$");
		Matcher m = p.matcher(str);   
		return m.matches();  
	}
	public static boolean isName(String str)
	{  
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]{2,4}$");
		Matcher m = p.matcher(str);   
		return m.matches();  
	}
}