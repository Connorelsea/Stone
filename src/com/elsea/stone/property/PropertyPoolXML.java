package com.elsea.stone.property;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PropertyPoolXML {
	
	private Document doc;
	
	public PropertyPoolXML(PropertyPool from)
	{
		
	}
	
	public void create(PropertyPool pool)
	{
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			doc = builder.newDocument();
			
			PropertyGroup pe = pool.getParent();
			
			Element parent = doc.createElement(pe.getName());
			doc.appendChild(parent);
			
			pe.getChildren()
			
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
	}

}