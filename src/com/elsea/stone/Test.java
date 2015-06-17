package com.elsea.stone;

public class Test
{

	public static void main(String[] args)
	{
		
		PropertyPoolTemplate p = new PropertyPoolTemplate();
		
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
		
	}
	
}