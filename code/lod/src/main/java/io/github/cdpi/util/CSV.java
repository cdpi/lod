package io.github.cdpi.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSV extends LOD
	{
	public static <T> Stream<T> parse(final Path path, final Function<CSVRecord, T> mapper, final CSVFormat format)
		{
		return io(() ->
			{
			try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, format))
				{
				return records.getRecords().stream().map(mapper);
				}
			});
		}

	public static <T> Stream<T> parse(final Path path, final Function<CSVRecord, T> mapper)
		{
		return parse(path, mapper, CSVFormat.DEFAULT);
		}

	public static String getFirstColumn(final CSVRecord record)
		{
		return record.get(0);
		}

	public static List<String> getListOfString(final Path path)
		{
		final var format = CSVFormat.Builder.create().setIgnoreEmptyLines(false).get();

		return parse(path, CSV::getFirstColumn, format).toList();
		}
	}
