package io.github.cdpi.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thing
	{
	protected final List<String> types = new ArrayList<>();

	protected final Map<String, Object> properties = new HashMap<>();

	public final List<String> getTypes()
		{
		return Collections.unmodifiableList(types);
		}

	public final void addType(final String type)
		{
		types.add(type);
		}

	public final void setType(final String type)
		{
		types.clear();

		types.add(type);
		}

	public final Map<String, Object> getProperties()
		{
		return Collections.unmodifiableMap(properties);
		}

	public final Thing set(final String key, final Object property)
		{
		properties.put(key, property);

		return this;
		}
	}
