package io.github.cdpi.wikidata;

import java.nio.file.Files;
import io.github.cdpi.util.LOD;
import io.github.cdpi.wikidata.model.EntityData;

public class Wikidata extends LOD
	{
	public void downloadEntity(final String id)
		{
		final var filename = String.format("%s.json", id);

		final var url = String.format("http://www.wikidata.org/entity/%s", filename);

		download(url, getWikidataDownloadPath(filename));
		}

	public void dev()
		{
		io(() ->
			{
			final var json = Files.readString(getWikidataDownloadPath("Q89.json"));

			final var data = EntityData.parse(json);

			System.out.println(toJSON(data.entities.get("Q89").labels));
			});
		}
	}
