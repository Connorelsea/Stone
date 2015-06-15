package com.elsea.stone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyGroup extends PropertyElement
{
	private List<PropertyElement> elements;
	
	public PropertyGroup()
	{
		elements = new ArrayList<PropertyElement>();
		setEmpty(true);
	}
	
	public void addElement(PropertyElement element)
	{
		elements.add(element);
	}
	
	public void removeElement(PropertyElement element)
	{
		elements.remove(element);
	}
	
	public List<PropertyElement> getChildrenOfName(String name)
	{
		return elements.stream()
			.filter(e -> e.getName().equals(name))
			.collect(Collectors.toList());
	}
	
	public PropertyElement getChildOfName(String name)
	{
		return null;
	}
	
	public boolean hasChildGroups()
	{
		if (elements.size() > 0 || getChildGroups().size() > 0) return false;
		else return true;
	}
	
	public List<PropertyElement> getChildGroups()
	{
		return elements.stream()
			.filter(e -> e instanceof PropertyGroup)
			.collect(Collectors.toList());
	}
	
	public List<PropertyElement> getChildProperties()
	{
		return elements.stream()
			.filter(e -> e instanceof Property)
			.collect(Collectors.toList());
	}
	
	public List<PropertyElement> getChildren()
	{
		return elements;
	}
	
	public void print()
	{
		System.out.println("Group: " + getName());
		
		for (PropertyElement element : elements)
		{
			element.print();
		}
	}
}