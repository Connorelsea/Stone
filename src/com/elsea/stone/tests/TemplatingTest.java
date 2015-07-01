package com.elsea.stone.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

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
		
		
		
	}
	
	@Test
	public void testObjectTemplate()
	{
		System.out.println("PROPERTY TEST WITH OBJECTS");
		
		p = new PropertyPool();
		
		p
			.group("objects")
				.object(new ExampleObject("Leopold", "Marx"))
				.object(new ExampleObject("Connor", "Elsea"))
			.end()
			
			.show();
	}

}