package com.elsea.stone.tests;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.elsea.stone.property.PropertyElement;
import com.elsea.stone.property.PropertyPool;
import com.elsea.stone.property.PropertyPoolReader;
import com.elsea.stone.property.PropertyPoolWriter;

public class ImplementationTest {

	@Test
	public void implement()
	{
		File file = new File("/home/connorelsea/Desktop/settings.xml");
		
		if (!file.exists())
		{
			PropertyPool pool = new PropertyPool();
			
			pool
				.group("user")
					.property("firstName", "connor").type("name")
					.property("lastName",  "elsea").type("name")
					.property("user", "second")
				.end()
				.group("path")
					.property("file", file.getAbsolutePath())
					.property("user", "more!")
				.end();
			
			PropertyPoolWriter writer = new PropertyPoolWriter();
			boolean success = writer.write(pool, file);
			
			if (success) System.out.println("Write successful.");
			else System.err.println("Write failed.");
			
			System.out.println("[Wrote Pool]");
			pool.show();
		}
		else
		{
			PropertyPoolReader reader = new PropertyPoolReader();
			boolean success = reader.read(file);
			
			if (success) System.out.println("Read successful.");
			else System.err.println("Read failed.");
			
			PropertyPool pool = reader.getPropertyPool();
			
			System.out.println("[Read Pool]");
			pool.show();
			
			System.out.println("[Searching For Name=User]");
			
			int searchType = 1;
			
			if (searchType == 0)
			{
				ArrayList<PropertyElement> props = pool.search()
						.filter(p -> p.getName().equals("user"));
					
				props.stream()
					.forEach(p -> System.out.println("Found: " + p.getName()));
			}
			else if (searchType == 1)
			{
				ArrayList<PropertyElement> props = pool.search()
						.filter(p -> p.getType().equals("name"));
					
				props.stream()
					.forEach(p -> System.out.println("Found: " + p.getName()));
			}
			
		}
	}
	
}