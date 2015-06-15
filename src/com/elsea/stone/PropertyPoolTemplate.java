package com.elsea.stone;

import java.util.Stack;

public class PropertyPoolTemplate
{
	private Stack<PropertyGroup> activeGroups;
	private Stack<PropertyGroup> groups;
	
	public PropertyPoolTemplate()
	{
		activeGroups = new Stack<PropertyGroup>();
		groups = new Stack<PropertyGroup>();
	}
	
	public PropertyPoolTemplate group(String name)
	{
		PropertyGroup group = new PropertyGroup();
		group.setName(name);
		
		if (activeGroups.size() > 0)
		{
			activeGroups.peek().addElement(group);
		}
		activeGroups.push(group);
		
		return this;
	}
	
	public PropertyPoolTemplate end()
	{
		if (activeGroups.size() > 0)
		{
			PropertyGroup group = activeGroups.pop();
			System.out.println("Ending group " + group.getName());
			groups.push(group);
		}
		else
		{
			System.err.println("Error: No active groups to end.");
		}
		
		return this;
	}
	
	public PropertyPoolTemplate property(String key, String defaultValue)
	{
		if (activeGroups.size() > 0)
		{
			Property property = new Property();
			property.setName(key);
			property.setDefaultValue(defaultValue);
			property.setCurrentValue(defaultValue);
			
			activeGroups.peek().addElement(property);
		}
		else
		{
			System.err.println("Error: No active groups, cannot add property.");
		}
		
		return this;
	}
	
	public PropertyPoolTemplate view()
	{
		Stack<PropertyGroup> buffer = (Stack<PropertyGroup>) groups.clone();
		
		for (int i = 0; i < buffer.size(); i++)
		{
			buffer.pop().print();
		}
		
		return this;
	}
	
}