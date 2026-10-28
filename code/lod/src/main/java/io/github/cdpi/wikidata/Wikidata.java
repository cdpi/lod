package io.github.cdpi.wikidata;

import java.io.IOException;
import io.github.cdpi.api.API;
import io.github.cdpi.api.ApacheClient;
import io.github.cdpi.util.LOD;
import io.github.cdpi.wikidata.model.EntityData;

public class Wikidata extends API
	{
	public Wikidata()
		{
		super(new ApacheClient());
		}

	public EntityData getEntity(final String id) throws IOException
		{
		return get(String.format("http://www.wikidata.org/entity/%s.json", id), EntityData.class);
		}

	@Deprecated
	public void downloadEntity(final String id) throws IOException
		{
		final var filename = String.format("%s.json", id);

		final var url = String.format("http://www.wikidata.org/entity/%s", filename);

		client.download(url, LOD.getWikidataDownloadPath(filename));
		}

	/*
	public void dev()
		{
		io(() ->
			{
			final var json = Files.readString(getWikidataDownloadPath("Q89.json"));

			final var data = EntityData.parse(json);

			System.out.println(toJSON(data.entities.get("Q89").labels));
			});
		}
	*/
	}
