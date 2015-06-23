package com.elsea.stone.property;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * PropertyGroup.java
 * 
 * A PropertyGroup is a container that can contain other PropertyGroups or
 * Property objects.
 * 
 * @author Connor M. Elsea
 */
public class PropertyGroup extends PropertyElement
{
	private List<PropertyElement> children;
	private PropertyGroup parent;
	
	public PropertyGroup()
	{
		children = new ArrayList<PropertyElement>();
		setEmpty(true);
	}
	
	public void setParent(PropertyGroup parent)
	{
		this.parent = parent;
	}
	
	public PropertyGroup getParent()
	{
		return parent;
	}
	
	public void addChild(PropertyElement element)
	{
		children.add(element);
	}
	
	public void removeChild(PropertyElement element)
	{
		children.remove(element);
	}
	
	public List<PropertyElement> getChildrenOfName(String name)
	{
		return children.stream()
			.filter(e -> e.getName().equals(name))
			.collect(Collectors.toList());
	}
	
	public PropertyElement getChildOfName(String name)
	{
		return null;
	}
	
	public boolean hasChildGroups()
	{
		if (children.size() > 0 || getChildGroups().size() > 0) return false;
		else return true;
	}
	
	public List<PropertyElement> getChildGroups()
	{
		return children.stream()
			.filter(e -> e instanceof PropertyGroup)
			.collect(Collectors.toList());
	}
	
	public List<PropertyElement> getChildProperties()
	{
		return children.stream()
			.filter(e -> e instanceof Property)
			.collect(Collectors.toList());
	}
	
	public List<PropertyElement> getChildren()
	{
		return children;
	}
	
	public void print(int level)
	{
		for (int i = 0; i < level; i++) {
			if (i < level - 1) System.out.print("|     ");
			else System.out.print("|     ");
		}
		System.out.println("Group: " + getName());
		
		for (PropertyElement element : children)
		{
			element.print(level + 1);
		}
	}

	@Override
	public void write(Document doc, Element parent)
	{
		
		Element group = doc.createElement(getName());
		parent.appendChild(group);
		
		children.stream()
			.forEach(child -> {
				child.write(doc, group);
			});
	}
}