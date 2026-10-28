package io.github.cdpi.wikidata.model;

import java.util.Map;

public class EntityData
	{
	public Map<String, Entity> entities;

	public static EntityData parse(final String json)
		{
		//return LOD.fromJSON(json, EntityData.class);
		throw new UnsupportedOperationException();
		}
	}
