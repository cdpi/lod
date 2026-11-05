package io.github.cdpi.lod.data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public abstract class CSV<T> implements DataSource<T>
	{
	protected final Function<CSVRecord, T> deserializer;

	public CSV(final Function<CSVRecord, T> deserializer)
		{
		super();

		this.deserializer = deserializer;
		}

	public final Path getPath()
		{
		return DataSource.super.getPath("csv");
		}

	public List<T> parse(final Path path, final CSVFormat format) throws IOException
		{
		try (final var records = CSVParser.parse(path, StandardCharsets.UTF_8, format))
			{
			return records.getRecords().stream().map(deserializer).toList();
			}
		}

	public List<T> parse(final Path path) throws IOException
		{
		return parse(path, CSVFormat.DEFAULT);
		}

	@Deprecated
	public static String getFirstColumn(final CSVRecord record)
		{
		//return record.get(0);

		throw new UnsupportedOperationException();
		}

	@Deprecated
	public static List<String> getListOfString(final Path path)
		{
		//final var format = CSVFormat.Builder.create().setIgnoreEmptyLines(false).get();
		//return parse(path, CSV::getFirstColumn, format).toList();

		throw new UnsupportedOperationException();
		}
	}
