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
	
	private Groups() { }
	
	public static Groups get()
	{
		if (instance == null) instance = new Groups();
		return instance;
	}
	
	/**
	 * Creates an XML document from a Stone Group. The XML document that
	 * was created is stored as a member of the Groups obect and  can be
	 * accessed via accessor methods.
	 * 
	 * @param group The Stone Group to create an XML document from
	 * @return      Instance of Groups object to allow chaining
	 */
	public Groups write(Group group)
	{
		try
		{
			// Create XML creation objects
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder        builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			
			// Create parent object
			org.w3c.dom.Element currentElement = element(group);
			
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
		org.w3c.dom.Element elem = element(child);
		parent.appendChild(elem);
		
		if (child.hasChildren())
			child.getChildren().stream().forEach(c -> recursive_write(elem, c) );
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
	
	/**
	 * Writes the current XML document to a file.
	 * 
	 * @param file The file to write the XML document to
	 * @return     A boolean indicating whether or not the write was successful
	 */
	public boolean to(File file)
	{
		return write(new StreamResult(file));
	}
	
	/**
	 * Shows the current XML document on System.out
	 */
	public void show()
	{
		write(new StreamResult(System.out));
	}
	
	/**
	 * Writes the current XML document to a specified Stream Result.
	 * 
	 * @param streamResult Location to write the XML document to.
	 * @return             A boolean indicating whether or not the
	 *                      write was successful.
	 */
	protected boolean write(StreamResult streamResult)
	{
		if (document != null)
		{
			try
			{
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
				DOMSource source = new DOMSource(document);
		 
				transformer.transform(source, streamResult);
				
				return true;
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		return false;
	}
	
}