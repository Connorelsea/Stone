package com.elsea.stone.property;

import java.io.File;

import javax.swing.text.AsyncBoxView.ChildLocator;
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
			
			NodeList list = doc.getChildNodes();
			result 		  = new PropertyPool();
			
			// Parse, setting parent as the first node
			parse(result, list.item(0));
			
			return true;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public void parse(PropertyPool pool, Node parent)
	{
		if (parent.hasChildNodes())
		{
			NodeList list = parent.getChildNodes();
			
			for (int i = 0; i < list.getLength(); i++)
			{
				Node current = list.item(i);
				
				if (current.getNodeType() == Node.ELEMENT_NODE)
				{
					Node attribute = current.getAttributes().item(0);
					boolean group  = false;
					
					if (attribute.getNodeName().equals("group") && attribute.getNodeValue().equals("true"))
					{
						group = true;
					}
					
					if (group)
					{
						pool.group(current.getNodeName());
						parse(pool, current);
						pool.end();
					}
					else
					{
						NodeList propertyChildren = current.getChildNodes();
						
						Node defaultNode = null;
						Node currentNode = null;
						
						String nodeName     = current.getNodeName();
						String defaultValue = null;
						String currentValue = null;
						
						for (int c = 0; c < propertyChildren.getLength(); c++)
						{
							Node child = propertyChildren.item(c);
							
							if (child.getNodeType() == Node.ELEMENT_NODE)
							{
								if (child.getNodeName().equals("default"))      defaultNode = child;
								else if (child.getNodeName().equals("current")) currentNode = child;
							}
						}
						
						if (defaultNode != null) defaultValue = defaultNode.getChildNodes().item(0).getNodeValue();
						if (currentNode != null) currentValue = currentNode.getChildNodes().item(0).getNodeValue();
						
						pool.property(nodeName, defaultValue, currentValue);
					}
				}
				
			}
		}
		
	}
	
	public PropertyPool getPropertyPool() {
		return result;
	}
	
}