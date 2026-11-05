package io.github.cdpi.schema.parser;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.tuple.ImmutablePair;

public final class TypesParser extends Parser<CSVType>
	{
	public Map.Entry<String, CSVType> parse(final CSVRecord record)
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

	@Override
	public Map<String, CSVType> parse(final String csv)
		{
		final var format = CSVFormat.Builder.create().setHeader().setSkipHeaderRecord(true).get();

		try (final var records = CSVParser.parse(csv, format))
			{
			final var types = new HashMap<String, CSVType>();

			for (final var record : records)
				{
				final var type = parse(record);

				types.put(type.getKey(), type.getValue());
				}

			return types;
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
