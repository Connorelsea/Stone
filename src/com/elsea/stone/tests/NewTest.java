package com.elsea.stone.tests;

import org.junit.Test;

import com.elsea.stone.groups.Group;
import com.elsea.stone.groups.Groups;

public class NewTest {
	
	@Test
	public void implement()
	{
		
		Group g = new Group();
		
		g
			.group("locations")
				
				.group("location").id("systemGenerated")
					.property("name", "Pictures")
					.property("path", "C:\\Pictures")
					.property("default", "true")
				.end()
				
			.end()
			
			.group("userinfo")
				.property("username", "connorelsea")
				.property("first", "Connor")
				.property("last", "Elsea")
			.end();
		
		g.show();
		
		System.out.println(g.search().property("username").getName());
		
		Groups.get().write(g).show();
	}

}