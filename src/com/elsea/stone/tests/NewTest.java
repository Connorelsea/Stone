package com.elsea.stone.tests;

import org.junit.Test;

import com.elsea.stone.groups.Group;

public class NewTest {
	
	@Test
	public void implement()
	{
		
		Group g = new Group();
		
		g
			.group("locations")
				.property("createdBy", "username")
				.group("location").id("systemGenerated")
					.property("name", "Pictures")
					.property("path", "C:\\Pictures")
					.property("default", "true")
				.end()
				.group("location")
					.property("name", "Documents")
					.property("path", "C:\\Documents")
					.property("default", "false")
				.end()
			.end()
			.group("userinfo")
				.property("username", "connorelsea")
				.property("firstName", "Connor")
				.property("lastName", "Elsea")
				.property("pass", "aEr4%fGt86c")
				.property("birthday", "10.28.97")
			.end();
		
		g.show();
				
		
	}

}