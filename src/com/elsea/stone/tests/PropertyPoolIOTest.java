package com.elsea.stone.tests;

import java.io.File;

import org.junit.Test;

import com.elsea.stone.property.PropertyPool;
import com.elsea.stone.property.PropertyPoolReader;
import com.elsea.stone.property.PropertyPoolWriter;

public class PropertyPoolIOTest {
	
	@Test
	public void testWrite()
	{
		PropertyPool p = new PropertyPool();
		
		p
		.group("software")
		
			.property("Name", "Software")
		
			.group("behavior")
				.property("Close", "EXIT_ON_CLOSE")
			.end()
		
		.end()
		.show();
		
		PropertyPoolWriter writer = new PropertyPoolWriter();
		writer.write(p, new File("C:\\Users\\celsea\\Desktop\\test.xml"));
	}
	
	@Test
	public void testRead()
	{
		PropertyPoolReader reader = new PropertyPoolReader();
		File file = new File("C:\\Users\\celsea\\Desktop\\test.xml");
		reader.read(file);
		
		PropertyPool pool = reader.getPropertyPool();
		pool.show();
	}

}