package com.elsea.stone.tests;

import com.elsea.stone.property.PropertyPool;
import com.elsea.stone.property.SerializableProperty;

public class ExampleObject implements SerializableProperty {
	
	private String firstName;
	private String lastName;
	
	public ExampleObject(String first, String last) {
		this.firstName = first;
		this.lastName  = last;
	}

	@Override
	public void toProperty(PropertyPool pool) {
		
		pool
			.group("ExampleObject")
				.property("NAME_FIRST", firstName)
				.property("NAME_LAST", lastName)
			.end();
	}

}