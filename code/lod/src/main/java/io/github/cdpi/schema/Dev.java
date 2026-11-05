package io.github.cdpi.schema;

public class Dev
	{
	public static void main(String[] args)
		{
		final var thing = new Thing();

		thing.set("name", "Test");

		final var json = new Serializer().toJSON(thing);

		System.out.println(json);
		}
	}
