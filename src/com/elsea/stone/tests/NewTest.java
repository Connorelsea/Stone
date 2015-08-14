package com.elsea.stone.tests;

import java.io.File;

import org.junit.Test;

import com.elsea.stone.groups.Group;
import com.elsea.stone.groups.Groups;
import com.elsea.stone.groups.Property;

public class NewTest {
	
	@Test
	public void implement()
	{
		
		Group g = new Group();
		
		g
			.group("locations")
				
				.group("location").id("pics")
					.property("name", "Pictures")
					.property("path", "../Pictures")
					.property("default", "true")
				.end()
				
				.group("location").id("docs")
					.property("name", "Documents")
					.property("path", "../Documents")
					.property("default", "false")
				.end()
				
			.end()
			
			.group("user")
				.property("username", "connorelsea")
				.property("first", "Connor")
				.property("last", "Elsea")
			.end();
		
		Group gr = g.search().group("location");
		System.out.println(gr.getid());
		
		Property p = g.search().group("user")         // Return the group named "user"
					  .search().property("username"); // Return the property in "user" named "username"
		
		p.value("newUsername"); // Change the "username" property's value
		
		// TODO: Why does this cause bug?
		// List<Element> list = g.search().filter(e -> e.getid().equals("pics"));
		
		Groups.get().write(g).show();
		
		File file = new File("C:\\Users\\connorelsea\\Desktop\\test.xml");
		
		Groups.get().write(g).to(file);
		
		Group groupRead = Groups.get().read(file);
		
		System.out.println("ORIGINAL");
		g.show();
		
		System.out.println("NEW");
		groupRead.show();
	}

}