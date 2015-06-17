package com.elsea.stone.property;

/**
 * PropertyElement.java
 * 
 * An abstract representation of a data container that can either contain
 * other data containers or property data.
 * 
 * @author Connor M. Elsea
 */
public abstract class PropertyElement
{
	private String name;
	private boolean empty;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean isEmpty()
	{
		return empty;
	}
	
	public void setEmpty(boolean empty)
	{
		this.empty = empty;
	}
	
	public abstract void print(int level);
	
	public void print()
	{
		print(0);
	}
	
}