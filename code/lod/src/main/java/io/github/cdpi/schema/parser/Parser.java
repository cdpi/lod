package io.github.cdpi.schema.parser;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.tuple.ImmutablePair;
import io.github.cdpi.api.ApacheClient;

public final class Parser extends ApacheClient
	{
	public Map.Entry<String, CSVProperty> parseProperty(final CSVRecord record)
		{
		final var id = record.get(0);

		final var property = new CSVProperty()
			.id(id)
			.label(record.get(1))
			.comment(record.get(2))
			;

		return new ImmutablePair<String, CSVProperty>(id, property);
		}

	public Map<String, CSVProperty> parseProperties(final String csv) throws IOException
		{
		final var format = CSVFormat.Builder.create().setHeader().setSkipHeaderRecord(true).get();

		try (final var records = CSVParser.parse(csv, format))
			{
			final var properties = new HashMap<String, CSVProperty>();

			for (final var record : records)
				{
				final var property = parseProperty(record);

				properties.put(property.getKey(), property.getValue());
				}

			return properties;
			}
		}

	public Map.Entry<String, CSVType> parseType(final CSVRecord record)
		{
		final var id = record.get(0);

		final var type = new CSVType()
			.id(id)
			.label(record.get(1))
			.comment(record.get(2))
			.subTypeOf(record.get(3))
			.enumerationType(asStringOrNull(record.get(4)))
			.equivalentClass(record.get(5))
			.properties(asListOrNull(record.get(6)))
			.subTypes(asListOrNull(record.get(7)))
			.supersedes(record.get(8))
			.supersededBy(record.get(9))
			.isPartOf(record.get(10));

		return new ImmutablePair<String, CSVType>(id, type);
		}

	public Map<String, CSVType> parseTypes(final String csv) throws IOException
		{
		final var format = CSVFormat.Builder.create().setHeader().setSkipHeaderRecord(true).get();

		try (final var records = CSVParser.parse(csv, format))
			{
			final var types = new HashMap<String, CSVType>();

			for (final var record : records)
				{
				final var type = parseType(record);

				types.put(type.getKey(), type.getValue());
				}

			return types;
			}
		}

	public Map<String, CSVType> downloadAndParseTypes() throws IOException
		{
		return parseTypes(getAsString("https://schema.org/version/latest/schemaorg-current-https-types.csv"));
		}

	public Map<String, CSVProperty> downloadAndParseProperties() throws IOException
		{
		return parseProperties(getAsString("https://schema.org/version/latest/schemaorg-current-https-properties.csv"));
		}

	public String asStringOrNull(final String value)
		{
		return value.isBlank() ? null : value;
		}

	public List<String> asListOrNull(final String value)
		{
		if (value.isBlank())
			{
			return null;
			}

		return Arrays.stream(value.split(",")).map(String::trim).toList();
		}
	}
