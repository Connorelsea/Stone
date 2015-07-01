package com.elsea.stone.property;

import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PropertyPoolReader {
	
	private PropertyPool result;

	public boolean read(File file)
	{
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			PropertyPool pool = new PropertyPool();
			NodeList list 	  = doc.getChildNodes();
			
			// Parse, setting parent as the first node
			result = parse(doc, list.item(0));
			
			return true;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public PropertyPool parse(Document doc, Node parent)
	{
		if (parent.hasChildNodes())
		{
			NodeList list = parent.getChildNodes();
			
			for (int i = 0; i < list.getLength(); i++)
			{
				
			}
		}
		
		return null;
	}
	
	public PropertyPool getPropertyPool() {
		return result;
	}
	
}