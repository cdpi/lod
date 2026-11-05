package io.github.cdpi.schema.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Parser<T extends CSVTypeOrProperty<T>>
	{
	public abstract Map<String, T> parse(final String csv);

	public final String asStringOrNull(final String value)
		{
		return value.isBlank() ? null : value;
		}

	public final List<String> asListOrNull(final String value)
		{
		if (value.isBlank())
			{
			return null;
			}

		return Arrays.stream(value.split(",")).map(String::trim).toList();
		}
	}
