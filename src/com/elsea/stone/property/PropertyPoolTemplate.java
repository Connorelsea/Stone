package com.elsea.stone.property;

import java.util.Stack;

public class PropertyPoolTemplate
{
	private PropertyGroup parent;
	private Stack<PropertyGroup> history;
	
	public PropertyPoolTemplate()
	{
		history = new Stack<PropertyGroup>();
		
		parent = new PropertyGroup();
		parent.setName("parent");
		
		history.push(parent);
	}
	
	public PropertyPoolTemplate group(String name)
	{
		_addGroup(name, parent);
		return this;
	}
	
	private void _addGroup(PropertyGroup group, PropertyGroup to)
	{
		history.peek().addChild(group);
		history.push(group);
	}
	
	private void _addGroup(String ofName, PropertyGroup to)
	{
		PropertyGroup group = new PropertyGroup();
		group.setName(ofName);
		_addGroup(group, to);
	}
	
	public PropertyPoolTemplate end()
	{
		history.pop();
		return this;
	}
	
	public PropertyPoolTemplate property(String name, String value)
	{
		Property property = new Property();
		property.setName(name);
		property.setDefaultValue(value);
		property.setCurrentValue(value);
		
		history.peek().addChild(property);
		
		return this;
	}
	
	public void show()
	{
		parent.print(0);
	}
	
	public PropertyGroup getParent()
	{
		return parent;
	}
	
}