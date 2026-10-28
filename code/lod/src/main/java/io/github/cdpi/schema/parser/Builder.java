package io.github.cdpi.schema.parser;

import java.util.Map;

public final class Builder
	{
	public void build(final Map<String, CSVType> csvTypes, final Map<String, CSVProperty> csvProperties)
		{
		final var x = csvTypes.values().stream()
			.filter(csvType -> csvType.enumerationType() != null)
			.limit(50)
			.map(CSVType::enumerationType)
			.toList();

		System.out.println(x);
		}
	}
