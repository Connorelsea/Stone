package com.elsea.stone.groups;

public class Group extends Element
{
	public Group(String name, Group parent)
	{
		super(name, null, parent);
	}
	
	public Group(String name)
	{
		super(name, null, null);
	}
	
	public Group()
	{
		super("parent", null, null);
	}
	
	/**
	 * Creates a new group as a child of  the current  group and
	 * returns the newly made child group, effectively switching
	 * to the new child group during template creation.
	 * 
	 * @param name The name of the group to create
	 * @return     The created group
	 */
	public Group group(String name)
	{
		Group group = new Group(name, this);
		addChild(group);
		return group;
	}
	
	/**
	 * Creates a new property with the given name and sets both the
	 * current and default values as the  same  value. The  current
	 * parent group is returned.
	 * 
	 * @param name  The name of the new property
	 * @param value The default and current value of the new property
	 * @return      The current parent group
	 */
	public Group property(String name, String value)
	{
		Property property = new Property(name, value, this);
		addChild(property);
		return this;
	}
	
	/**
	 * Sets the ID of the current group and returns the current group.
	 * 
	 * @param id The ID of the current group.
	 * @return   The group
	 */
	public Group id(String id)
	{
		setID(id);
		return this;
	}
	
	/**
	 * Returns the parent of this group, effectively ending
	 * the possibility for the addition of  children during
	 * template creation.
	 * 
	 * @return The parent of the current group
	 */
	public Group end()
	{
		return getParent();
	}
	
}