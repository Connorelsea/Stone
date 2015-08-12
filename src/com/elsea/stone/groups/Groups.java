package com.elsea.stone.groups;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class Groups {
	
	private static Document document;
	private static Group    current;
	private static org.w3c.dom.Element currentElement;
	
	public static void write(Group group)
	{
		try
		{
			// Create XML creation objects
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder        builder = factory.newDocumentBuilder();
			
			document = builder.newDocument();
			
			// Create parent object
			current = group;
			currentElement = group(group);
			
			if (current.hasChildren())
			{
				for (Element e : group.getChildren())
				{
					if (e instanceof Group)
					{
						
					}
				}
			}
			
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
	}
	
	protected static void recursive_write()
	{
		
	}
	
	protected static org.w3c.dom.Element group(Group group)
	{
		org.w3c.dom.Element e = document.createElement("group");
		
		Attr a_name = document.createAttribute("name");
		a_name.setValue(group.getName());
		e.setAttributeNode(a_name);
		
		Attr a_id = document.createAttribute("id");
		a_id.setValue(group.getid());
		e.setAttributeNode(a_id);
		
		return e;
	}
	
	public static boolean to(File file)
	{
		
		return false;
	}
	
}