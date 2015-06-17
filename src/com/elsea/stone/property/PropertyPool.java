package com.elsea.stone.property;

import java.util.Stack;

/**
 * PropertyPoolTemplate
 * 
 * A Property Pool is a mutable collection of Property Elements with methods to
 * assist in Property Pool creation and alteration.
 * 
 * @author Connor M. Elsea
 */
public class PropertyPool
{
	private PropertyGroup parent;
	private Stack<PropertyGroup> history;
	
	/**
	 * Creates a new Property Pool object and  performs  the  initial  set  up.
	 * 
	 * The initial set up consists of instantiating the history stack, creating
	 * a new Property Group object to be used as the  parent  group,  and  then
	 * pushing this new group to the top of the currently empty history  stack.
	 * 
	 * This ensures that any added base-level Property Groups will not  be  met
	 * with an empty history stack and no parent to attach themselves to.
	 */
	public PropertyPool()
	{
		history = new Stack<PropertyGroup>();
		
		parent = new PropertyGroup();
		parent.setName("parent");
		
		history.push(parent);
	}
	
	/**
	 * Create a new Property Group as a child of the most recent group.  If no
	 * groups have been created or all user-created groups have been ended,the
	 * new group will be added as a child of the parent group.
	 * 
	 * In order to accomplish this a new Property Group object is created  and
	 * named and is then added as a child of the Property Group located on the
	 * top of the history stack. This new group is then pushed to the  top  of
	 * the history stack.
	 * 
	 * Every group should be ended with a call to the end method.
	 * 
	 *   p.group("settings")
	 *      .property("name", "Adam Smith");
	 *    .end();
	 * 
	 * @param name The name of the group to be created
	 * @return The current PropertyPool instance to allow chaining
	 */
	public PropertyPool group(String name)
	{
		_addGroup(name, parent);
		return this;
	}
	
	/**
	 * Adds the new group as a child of the current group, which is the  group
	 * located on the top of the history stack, and then pushes this new group
	 * to the top of the history  stack, thus making it the new  current group.
	 * 
	 * @param group The group to be added
	 * @param to The parent group the new group will be added to
	 */
	private void _addGroup(PropertyGroup group, PropertyGroup to)
	{
		history.peek().addChild(group);
		history.push(group);
	}
	
	/**
	 * Creates a new Property Group object, sets its name, and fires  the  add
	 * group method that takes a group object as a first argument. This method
	 * makes other methods easier to read and understand.
	 * 
	 * @param ofName The name of the group to be created
	 * @param to The parent group the new group will be added to
	 */
	private void _addGroup(String ofName, PropertyGroup to)
	{
		PropertyGroup group = new PropertyGroup();
		group.setName(ofName);
		_addGroup(group, to);
	}
	
	/**
	 * Shifts the current Property Group from the  current group to the  previous
	 * group. This should be called at the end of each group's child definitions.
	 * 
	 *   p.group("settings")
	 *      .property("name", "Adam Smith");
	 *    .end();
	 * 
	 * In order to accomplish this, the most recent  Property Group, which is the
	 * group on the top of the history stack, is removed.  This  means  that  the
	 * next time property or group methods are called, they will mutate the group
	 * prior to the one being ended, thus achieving desired functionality.
	 * 
	 * @return The current PropertyPool instance to allow chaining
	 */
	public PropertyPool end()
	{
		if (history.peek().getParent() == null)
		{
			System.err.println("Error: Cannot end the parent element");
		}
		else
		{
			history.pop();
		}
		return this;
	}
	
	/**
	 * Create a new Property  as a child of the most recent group.  If no properties
	 * have been  created  or all  user-created groups  have  been  ended,  the  new
	 * property will be added as a child of the parent group.
	 * 
	 * In order to accomplish this, a new Property object is created, set up, and is
	 * then added as a child to the Property Group at the top of the history  stack.
	 * 
	 * Usage is as follows.
	 * 
	 *   p.group("settings")
	 *      .property("name", "Adam Smith");
	 *    .end();
	 * 
	 * @param name The name of the group to be created
	 * @return The current PropertyPool instance to allow chaining
	 */
	public PropertyPool property(String name, String value)
	{
		Property property = new Property();
		property.setName(name);
		property.setDefaultValue(value);
		property.setCurrentValue(value);
		
		history.peek().addChild(property);
		
		return this;
	}
	
	/**
	 * Visualizes and prints the structure currently held by the Property Pool.
	 */
	public void show()
	{
		parent.print(0);
	}
	
	public PropertyGroup getParent()
	{
		return parent;
	}
	
}