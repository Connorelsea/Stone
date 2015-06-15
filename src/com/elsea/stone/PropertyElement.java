package com.elsea.stone;

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
	
	public void print()
	{
		System.out.println(name);
	}
	
}