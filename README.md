![Stone Java preferences and settings library](http://i.imgur.com/lozt4ce.png)

Stone is a concise yet powerful preferences library for Java that handles, loads, and saves application settings and preferences.

```
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