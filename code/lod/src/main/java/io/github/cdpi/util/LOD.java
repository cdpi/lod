package io.github.cdpi.util;

import java.nio.file.Path;

public class LOD
	{
	public static Path getDataPath(final String ...parts)
		{
		return Path.of("data", parts);
		}

	public static Path getWikidataDownloadPath(final String filename)
		{
		return Path.of("data", "wikidata", "download", filename);
		}
	}
