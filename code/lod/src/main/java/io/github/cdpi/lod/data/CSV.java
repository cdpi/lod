package io.github.cdpi.lod.data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public abstract class CSV<T> implements DataSource<T>
	{
	protected final Function<CSVRecord, T> deserializer;

	public CSV(final Function<CSVRecord, T> deserializer)
		{
		this.deserializer = deserializer;
		}

	public Stream<T> parse(final Path path, final CSVFormat format) throws IOException
		{
		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, format))
			{
			return records.getRecords().stream().map(deserializer);
			}
		}

	public Stream<T> parse(final Path path) throws IOException
		{
		return parse(path, CSVFormat.DEFAULT);
		}
	}
