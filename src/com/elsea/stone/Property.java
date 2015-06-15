package com.elsea.stone;


/**
 * Property.java
 * 
 * A Property is a container holding information about a  property  such as
 * its name, current value, default value,  and  type.  Types  help  relate
 * properties, which is useful for querying the Property Pool and returning
 * an array of all Properties of a certain type.
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
	
}