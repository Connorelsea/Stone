![Stone Java preferences and settings library](http://i.imgur.com/lozt4ce.png)

Stone is a concise yet powerful preferences library for Java that handles, loads, and saves application settings and preferences.

Use simple and concise Java code to create a data structure that holds various settings and information for your program. You can easily define templates (shown below) that hold both the current value and the default value, making it easy to allow the user to revert to default settings. Under the hood, Stone is handling the data as XML whenever you choose to save it to the file system or read it back in. Stone abstracts away the XML for the programmer, allowing them to focus on the data instead. Creating, reading, and handling comparable data using Java's built in XML libraries would take hundreds more lines of code than what is seen below. Stone makes sure your data is formatted correctly for the purpose at hand: settings and property storage.

```java
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
```