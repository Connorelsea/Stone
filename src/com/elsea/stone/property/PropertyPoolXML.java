package com.elsea.stone.property;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PropertyPoolXML {
	
	private Document doc;
	
	public PropertyPoolXML()
	{
		
	}
	
	public void create(PropertyPool pool)
	{
		try
		{
			/* Create objects neccesary for Java XML creation */
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			doc = builder.newDocument();
			
			/* Get the base parent group */
			PropertyGroup parentGroup = pool.getParent();
			
			/* Create XML element for the parent group and append it to the XML document */
			Element parent = doc.createElement("DOC_DIRECT_CHILD");
			doc.appendChild(parent);
			
			parentGroup.write(doc, parent);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(System.out);
			transformer.transform(source, result);
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (TransformerConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (TransformerException e)
		{
			e.printStackTrace();
		}
	}

}