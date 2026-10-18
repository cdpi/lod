package io.github.cdpi.lod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Util
	{
	public static <T> Stream<T> csv(final Path path, final Function<CSVRecord, T> mapper) throws IOException
		{
		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, CSVFormat.DEFAULT))
			{
			return records.getRecords().stream().map(mapper);
			}
		}
	}
