package io.github.cdpi.schema.parser;

public class Dev
	{
	public static void main(String[] args) throws Exception
		{
		final var parser = new Parser();

		//final var properties = parser.downloadAndParseProperties();
		//System.out.println(properties.size());

		final var types = parser.downloadAndParseTypes();
		System.out.println(types.size());

		final var builder = new Builder();

		builder.build(types, null);
		}
	}
