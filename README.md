![Stone Java preferences and settings library](http://i.imgur.com/lozt4ce.png)

Stone is a concise yet powerful preferences library for Java that handles, loads, and saves application settings and preferences.

## Stone Use Cases
Use simple and concise Java code to create a data structure that holds various settings and information for your program. You can easily define templates (shown below) that hold both the current value and the default value, making it easy to allow the user to revert to default settings.


```java
p
	.group("software")

		.property("Name", "Software")

		.group("behavior")
			.property("Close", "EXIT_ON_CLOSE")
			.property("Open",  "OPEN_MAIN_MODERN")
		.end()

	.end()

	.group("user")
	
		.group("info")
			.property("Name", "John A. Smith")
			.property("Age", "25")
		.end()
		
	.end()
```

## Under The Hood: Design
Data for the programmer is represented using the Property, PropertyElement, PropertyGroup, and PropertyPool classes. Under the hood, Stone stores the data on your system as XML. This makes the saving format fairly universal and easily transferable. Comparable Java code that is creating, reading, and handling pure XML data using Java's built in XML libraries would take hundreds more lines than the code seen above. Stone makes sure your data is formatted correctly for the purpose at hand: settings and property storage.