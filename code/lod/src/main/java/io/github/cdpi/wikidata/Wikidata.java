package io.github.cdpi.wikidata;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;

public class Wikidata
	{
	public Entity getEntity(final String id) throws IOException
		{
		final var ua = "LOD/0.0.1 (https://github.com/cdpi/lod)";

		final var url = String.format("http://www.wikidata.org/entity/%s.json", id);

		final var json = Request.Get(url).userAgent(ua).execute().returnContent().asString(StandardCharsets.UTF_8);

		final var data = new Gson().fromJson(json, EntityData.class);

		return data.entities.get(id);
		}
	}
