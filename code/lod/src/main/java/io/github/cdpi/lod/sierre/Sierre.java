package io.github.cdpi.lod.sierre;

import java.io.IOException;
import java.nio.file.Path;
import io.github.cdpi.schema.ItemList;
import io.github.cdpi.schema.Thing;

public class Sierre
	{
	public static void streets() throws IOException
		{
		final var streets = new Streets().get(Path.of("data", "sierre", "streets.csv"));

		final var things = streets.map(Street::toAdministrativeArea).toList();

		final var list = new ItemList<>(things);

		System.out.println(Thing.toString(list));
		}
	}
