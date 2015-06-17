package com.elsea.stone.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.elsea.stone.property.PropertyPoolTemplate;

public class TemplatingTest {
	
	private PropertyPoolTemplate p;

	@Before
	public void setUp()
	{
		p = new PropertyPoolTemplate();
	}
	
	@Test
	public void testTemplate()
	{
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
	}

}