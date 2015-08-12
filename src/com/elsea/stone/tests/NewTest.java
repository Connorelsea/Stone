package com.elsea.stone.tests;

import org.junit.Test;

import com.elsea.stone.groups.Group;

public class NewTest {
	
	@Test
	public void implement()
	{
		
		Group g = new Group();
		
		g
			.group("locations").id("gid")
				.property("test", "value").id("pid")
				.property("test2", "value").id("pid2")
			.end()
			.group("userinfo")
				.property("username", "connor")
			.end();
		
		g.show();
				
		
	}

}