package com.elsea.stone.groups;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

public class Groups {
	
	private static Groups instance;
	private Document document;
	private org.w3c.dom.Element currentElement;
	
	private Groups() { }
	
	public static Groups get()
	{
		if (instance == null) instance = new Groups();
		return instance;
	}
	
	public Groups write(Group group)
	{
		try
		{
			// Create XML creation objects
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder        builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			
			// Create parent object
			currentElement = element(group);
			
			// Add top-most element directly to XML document
			document.appendChild(currentElement);
			
			if (group.hasChildren())
				group.getChildren().stream().forEach(child -> recursive_write(currentElement, child) );
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		
		return this;
	}
	
	protected void recursive_write(org.w3c.dom.Element parent, Element child)
	{
		parent.appendChild(element(child));
		
		if (child.hasChildren())
			child.getChildren().stream().forEach(c -> recursive_write(currentElement, child) );
	}
	
	/**
	 * Create an XML element from a Property or Group
	 * 
	 * @param element The Stone element to transform
	 * @return        A Stone element transformed into an XML element
	 */
	protected org.w3c.dom.Element element(Element element)
	{
		org.w3c.dom.Element e = null;
		
		// TODO try, e.setAttribute(name, value);
		
		Attr a_name = document.createAttribute("name");
		a_name.setValue(element.getName());
		
		Attr a_id = document.createAttribute("id");
		a_id.setValue(element.getid());
		
		if (element instanceof Group)
		{
			e = document.createElement("group");
			e.setAttributeNode(a_name);
		}
		
		else if (element instanceof Property)
		{
			e = document.createElement("property");
			
			Attr a_val_current = document.createAttribute("currentValue");
			a_val_current.setValue(element.getCurrentValue());
			e.setAttributeNode(a_val_current);
			
			Attr a_val_default = document.createAttribute("defaultValue");
			a_val_default.setValue(element.getDefaultValue());
			e.setAttributeNode(a_val_default);
		}
		
		e.setAttributeNode(a_name);
		e.setAttributeNode(a_id);
		
		return e;
	}
	
	public boolean to(File file)
	{
		
		return false;
	}
	
	public void show()
	{
		if (document != null)
		{
			try
			{
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
				DOMSource source    = new DOMSource(document);
				StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else
		{
			System.out.println("Warning: XML not shown. Cannot show null document.");
		}
	}
	
}