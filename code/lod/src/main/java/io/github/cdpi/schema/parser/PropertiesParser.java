package io.github.cdpi.schema.parser;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.tuple.ImmutablePair;

public final class PropertiesParser extends Parser<CSVProperty>
	{
	public Map.Entry<String, CSVProperty> parse(final CSVRecord record)
		{
		final var id = record.get(0);

		final var property = new CSVProperty()
			.id(id)
			.label(record.get(1))
			.comment(record.get(2))
			;

		return new ImmutablePair<String, CSVProperty>(id, property);
		}

	@Override
	public Map<String, CSVProperty> parse(final String csv)
		{
		final var format = CSVFormat.Builder.create().setHeader().setSkipHeaderRecord(true).get();

		try (final var records = CSVParser.parse(csv, format))
			{
			final var properties = new HashMap<String, CSVProperty>();

			for (final var record : records)
				{
				final var property = parse(record);

				properties.put(property.getKey(), property.getValue());
				}

			return properties;
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
