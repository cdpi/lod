package io.github.cdpi.sierre;

import java.nio.file.Path;
import java.util.stream.Stream;
import io.github.cdpi.geo.Street;
import io.github.cdpi.util.CSV;
import io.github.cdpi.util.LOD;

public class Sierre extends LOD
	{
	public Stream<Street> getStreets(final Path path)
		{
		return CSV.parse(path, Street::from);
		}

	public Stream<Street> getStreets()
		{
		return getStreets(getDataPath("sierre", "streets.csv"));
		}

	public void dev()
		{
		final var jsonld = Street.toItemList(getStreets());

		System.out.println(jsonld);
		}
	}
