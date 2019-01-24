import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class ReadXmlFile 
{

	public static void main(String[] args)
	{
		try
		{
			File xmlfile=new File("student.xml");
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document d=(Document) db.parse(xmlfile);
			
			System.out.println(((org.w3c.dom.Document) d).getDocumentElement().getNodeName());
			
			NodeList nlist=((org.w3c.dom.Document) d).getElementsByTagName("student");
			
			
			for(int i=0; i<nlist.getLength(); i++)
			{
				Node nNode =nlist.item(i);
				System.out.println(nNode.getNodeName());
				
				if(nNode.getNodeType()==Node.ELEMENT_NODE)
				{
					Element e=(Element) nNode;
					System.out.println("Student Id"+" "+(e).getAttribute("idno"));
					System.out.println("First Name"+(e).getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name"+(e).getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("score"+(e).getElementsByTagName("score").item(0).getTextContent());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
