package com.elsea.stone;

import java.util.Stack;

public class PropertyPoolTemplate
{
	private Stack<PropertyGroup> groups;
	private PropertyGroup head;
	
	public PropertyPoolTemplate()
	{
		groups = new Stack<PropertyGroup>();
	}
	
	/**
	 * Start a new group nested under the current group. If there is no current group,
	 * a central parent group will be created and all children groups will  be  nested
	 * within in.
	 * 
	 * @param name The name of the group to be created
	 */
	public PropertyPoolTemplate group(String name)
	{
		if (groups.size() == 0)
		{
			PropertyGroup group = new PropertyGroup();
			group.setName("Central Parent Group");
			groups.push(group);
		}
		
		// need to address parent groups
		
		PropertyGroup group = new PropertyGroup();
		group.setName(name);
		groups.push(group);
		
		return this;
	}
	
	public PropertyPoolTemplate end()
	{
		int size = groups.size();
		
		if (size == 0)
		{
			System.err.println("Error: Cannot use end. No groups have been created.");
		}
		
		
		return this;
	}
	
	public PropertyPoolTemplate showStack()
	{
		for (int i = groups.size() - 1; i >= 0; i--)
		{
			System.out.println(i + ". " + groups.get(i).getName());
		}
		
		return this;
	}
	
}