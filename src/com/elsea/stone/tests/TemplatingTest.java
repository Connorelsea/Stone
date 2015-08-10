package com.elsea.stone.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.elsea.stone.property.Property;
import com.elsea.stone.property.PropertyElement;
import com.elsea.stone.property.PropertyGroup;
import com.elsea.stone.property.PropertyPool;

public class TemplatingTest {
	
	private PropertyPool p;
	
	@Test
	public void testTemplate()
	{
		p = new PropertyPool();
		
		p
			.group("software")
			
				.property("Name", "Software")
			
				.group("behavior")
					.property("Close", "EXIT_ON_CLOSE")
					.property("Open",  "OPEN_MAIN_MODERN")
				.end()
				
				.group("paths")
					.property("SaveLocation", "NO_DEFAULT")
				.end()
			
			.end()
			
			.group("user")
			
				.group("info")
					.property("Name", "NULL")
					.property("Age", "NULL")
				.end()
				
			.end()
			
			.show();
		
		assertEquals("Parent element exists", "parent", p.getParent().getName());
		
		p.showXML();
		
		// Search for child elements of certain group
		
		List<PropertyElement> list = p.search().getElementsInGroup("behavior");
		
		for (PropertyElement e : list) System.out.println(e.getName());
		
		// Search for specific property
		
		Property prop = p.search().getProperty("Close");
		
		System.out.println(prop.getCurrentValue());
		
		// Search for specific group
		
		PropertyGroup group = p.search().getGroup("info");
		
		System.out.println(group.getChildAt(1).getName());
		
		// Search for duplicates
		
		boolean hasDuplicates  = p.search().hasDuplicatesOf("Name");
		
		System.out.println(hasDuplicates);
		
		boolean hasDuplicates2 = p.search().hasDuplicatesOf("behavior");
		
		System.out.println(hasDuplicates2);
		
	}
	
}