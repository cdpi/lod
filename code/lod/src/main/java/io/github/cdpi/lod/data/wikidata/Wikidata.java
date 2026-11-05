package io.github.cdpi.lod.data.wikidata;

import java.nio.file.Path;

import io.github.cdpi.util.http.API;
import io.github.cdpi.util.http.ApacheClient;

public class Wikidata extends API
	{
	public Wikidata()
		{
		super(new ApacheClient());
		}

	public EntityData getEntity(final String id)
		{
		return get(String.format("http://www.wikidata.org/entity/%s.json", id), EntityData.class);
		}

	@Deprecated
	public void downloadEntity(final String id)
		{
		/*
		final var filename = String.format("%s.json", id);

		final var url = String.format("http://www.wikidata.org/entity/%s", filename);

		client.download(url, LOD.getWikidataDownloadPath(filename));
		*/

		throw new UnsupportedOperationException();
		}

	@Deprecated
	public static Path getWikidataDownloadPath(final String filename)
		{
		//return Path.of("data", "wikidata", "download", filename);

		throw new UnsupportedOperationException();
		}
	}
