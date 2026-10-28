package io.github.cdpi.schema;

import java.util.HashMap;
import java.util.Map;

public class Thing
	{
	//"@context": "https://schema.org/",

	// Peut avoir plusieurs types
	//"@type": ["HotelRoom","Product"],

	protected final Map<String, Object> properties = new HashMap<>();

	public Thing set(final String key, final Object property)
		{
		properties.put(key, property);

		return this;
		}
	}
