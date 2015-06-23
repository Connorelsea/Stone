package com.elsea.stone.property;

import java.io.File;

import javax.xml.parsers.*;

import org.w3c.dom.Document;

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
			
			result = parse(doc);
			
			return true;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public PropertyPool parse(Document doc)
	{	
		return null;
	}
	
	public PropertyPool getPropertyPool() {
		return result;
	}
	
}