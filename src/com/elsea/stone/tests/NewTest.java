package com.elsea.stone.tests;

import java.io.File;

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
		
		Groups.get().write(g).show();
		
		Groups.get().write(g).to(new File("C:\\Users\\connorelsea\\Desktop\\test.xml"));
	}

}