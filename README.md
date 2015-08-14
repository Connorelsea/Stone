![Stone Java preferences and settings library](http://i.imgur.com/vWuI5Ib.png)

Stone is a concise yet powerful preferences library for Java that handles, loads, and saves application settings and preferences.

## What is Stone
Using Stone, you can use simple, concise, and easy-to-read Java code to create a data structure that holds various settings and information for your program.

#### Creating a Preferences Template
You can define templates for this data (shown below) that hold current and default values, making it easy for the user to not only change settings during runtime with ease, but also revert back to default settings if needed on a per-property basis.

```java

	Group g = new Group();
		
	g
		.group("locations")
				
			.group("location").id("pics")
				.property("name", "Pictures")
				.property("path", "../Pictures")
			.end()
				
			.group("location").id("docs")
				.property("name", "Documents")
				.property("path", "../Documents")
			.end()
				
		.end()
			
		.group("user")
			.property("first", "Connor")
			.property("last", "Elsea")
		.end();
```

#### Writing your preferences
One of the benefits of Stone is not having to worry about the data's implementation or dealing with complicated structures, writing to files, and wasting time writing the same things over and over again for multiple programs.

Writing to a file is as simple as one line of code.

```java

	Groups.get().write(g).to(new File("C:\\stone.xml"));
```

#### View your preference structure
If needed, you can easily visualize the data held in a group with ease.

Showing the abstract representation of the data in System.out, which is recomended, is as simple as this one-liner.

```java

	g.show()
```

Showing the structure of the XML document is also simple, but requires building the XML document first.

```java

	Groups.get().write(g).show();
```

#### Altering preferences during runtime
You can easily allow the user to change preferences during runtime. Java 8 stream-like search functionality enabled on each group allows for quick, easy, and functional searching of groups containing properties and other groups.

```java

	Property p = g.search().group("user")         // Return the group named "user"
	              .search().property("username"); // Return the property in "user" named "username"
		
	p.value("newUsername"); // Change the "username" property's value
```

Not only can you use in the plentiful built in search methods, but you can also use a customized filter.

```java

	List<Element> list = g.search().filter(e -> e.getid().equals("pics"));
```

## Under The Hood: Design
Coming Soon