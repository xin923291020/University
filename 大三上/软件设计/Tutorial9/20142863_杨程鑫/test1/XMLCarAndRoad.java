package test1;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XMLCarAndRoad {

	@SuppressWarnings("rawtypes")
	public static Object getBean(int i)
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src/test1/config.xml"));
			
			NodeList nl = doc.getElementsByTagName("className");
			Node classNode = nl.item(i).getFirstChild();
			String className = classNode.getNodeValue();
			
			Class c = Class.forName("test1."+className);
			Object obj = c.newInstance();
			return obj;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
}
