package com.elsea.stone.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.elsea.stone.property.Property;

public class PropertyTest {

	private Property property;
	
	@Before
	public void setUp()
	{
		property = new Property();
	}
	
	@Test
	public void testEmptiness()
	{
		Property newProperty = new Property();
		assertEquals("Any property should initially be empty",  true, newProperty.isEmpty());
	}
	
	@Test
	public void testMutableName()
	{
		property.setName("name");
		assertEquals("Value of name should be what is set", "name", property.getName());
	}
	
	@Test
	public void testSettingValue()
	{
		property.setDefaultValue("valueDefault");
		assertEquals("Value default should equal what it is set to", "valueDefault", property.getDefaultValue());
		
		property.setCurrentValue("valueCurrent");
		assertEquals("Value current should equal what it is set to", "valueCurrent", property.getCurrentValue());
	}
	
}