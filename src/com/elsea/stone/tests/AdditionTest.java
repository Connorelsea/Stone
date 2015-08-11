package com.elsea.stone.tests;

import org.junit.Test;

import com.elsea.stone.property.PropertyGroup;
import com.elsea.stone.property.PropertyPool;

public class AdditionTest {
	
	@Test
	public void implement()
	{
		PropertyPool pool = new PropertyPool();
		
		pool
			.group("locations")
				.group("location")
					.property("name",    "My Pictures")
					.property("path",    "C:\\user\\pictures")
					.property("default", "true")
				.end()
				.group("location")
					.property("name",    "My Documents")
					.property("path",    "C:\\user\\documents")
					.property("default", "false")
				.end()
			.end();
		
		PropertyGroup group = pool.search().getGroup("locations");
		
		group.show();
	}

}