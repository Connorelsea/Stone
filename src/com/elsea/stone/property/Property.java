package com.elsea.stone.property;


/**
 * Property.java
 * 
 * A Property is a container holding information about a  property  such as
 * its name, current value, default value.
 * 
 * @author Connor M. Elsea
 */
public class Property extends PropertyElement
{
	private String currentValue;
	private String defaultValue;
	
	public Property()
	{
		setEmpty(true);
	}
	
	public void setCurrentValue(String currentValue)
	{
		this.currentValue = currentValue;
	}
	
	public String getCurrentValue()
	{
		return currentValue;
	}
	
	public void setDefaultValue(String defaultValue)
	{
		this.defaultValue = defaultValue;
	}
	
	public String getDefaultValue()
	{
		return defaultValue;
	}
	
	
	public void print(int level)
	{
		for (int i = 0; i < level; i++) System.out.print("|     ");
		System.out.println("> (" + getName() + " : " + currentValue + ")");
	}
	
}