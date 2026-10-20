package io.github.cdpi.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSV extends LOD
	{
	public static <T> Stream<T> parse(final Path path, final Function<CSVRecord, T> mapper)
		{
		return io(() ->
			{
			try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, CSVFormat.DEFAULT))
				{
				return records.getRecords().stream().map(mapper);
				}
			});
		}
	}
