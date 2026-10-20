package io.github.cdpi.wikidata.model;

import java.util.Map;
import io.github.cdpi.util.LOD;

public class EntityData
	{
	public Map<String, Entity> entities;

	public static EntityData parse(final String json)
		{
		return LOD.fromJSON(json, EntityData.class);
		}
	}
