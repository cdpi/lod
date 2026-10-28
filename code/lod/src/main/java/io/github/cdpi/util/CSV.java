package io.github.cdpi.util;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

@Deprecated
public class CSV extends LOD
	{
	@Deprecated
	public static <T> Stream<T> parse(final Path path, final Function<CSVRecord, T> mapper, final CSVFormat format)
		{
		throw new UnsupportedOperationException();
		}

	@Deprecated
	public static <T> Stream<T> parse(final Path path, final Function<CSVRecord, T> mapper)
		{
		return parse(path, mapper, CSVFormat.DEFAULT);
		}

	@Deprecated
	public static String getFirstColumn(final CSVRecord record)
		{
		return record.get(0);
		}

	@Deprecated
	public static List<String> getListOfString(final Path path)
		{
		final var format = CSVFormat.Builder.create().setIgnoreEmptyLines(false).get();

		return parse(path, CSV::getFirstColumn, format).toList();
		}
	}
