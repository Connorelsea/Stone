![Stone Java preferences and settings library](http://i.imgur.com/lozt4ce.png)

Stone is a concise yet powerful preferences library for Java that handles, loads, and saves application settings and preferences.

| Stone Code | Generated XML |
|------------|---------------|
|```		PropertyPool pool = new PropertyPool();
		
		pool
			.group("settings")
				.group("user")
					.property("name", "John A. Smith")
					.property("age", "25")
				.end()
				.group("paths")
					.property("save", "C:\\user\\pictures")
				.end()
			.end();
		
		PropertyPoolWriter writer = new PropertyPoolWriter();
		writer.write(pool, file);``` | ```<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<DOC_DIRECT_CHILD>
    <parent>
        <software>
            <Name>
                <current>Software</current>
                <default>Software</default>
            </Name>
            <behavior>
                <Close>
                    <current>EXIT_ON_CLOSE</current>
                    <default>EXIT_ON_CLOSE</default>
                </Close>
                <Open>
                    <current>OPEN_MAIN_MODERN</current>
                    <default>OPEN_MAIN_MODERN</default>
                </Open>
            </behavior>
            <paths>
                <SaveLocation>
                    <current>NO_DEFAULT</current>
                    <default>NO_DEFAULT</default>
                </SaveLocation>
            </paths>
        </software>
        <user>
            <info>
                <Name>
                    <current>NULL</current>
                    <default>NULL</default>
                </Name>
                <Age>
                    <current>NULL</current>
                    <default>NULL</default>
                </Age>
            </info>
        </user>
    </parent>
</DOC_DIRECT_CHILD>
		```