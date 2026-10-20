package io.github.cdpi.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import org.apache.commons.lang3.function.FailableCallable;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LOD
	{
	public static final String UserAgent = "LOD/0.0.1 (https://github.com/cdpi/lod)";

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public static Path getDataPath(final String ...parts)
		{
		return Path.of("data", parts);
		}

	public static Path getWikidataDownloadPath(final String filename)
		{
		return Path.of("data", "wikidata", "download", filename);
		}

	public static <T> T fromJSON(final String json, final Class<T> classOfT)
		{
		return GSON.fromJson(json, classOfT);
		}

	public static String toJSON(final Object model)
		{
		return GSON.toJson(model);
		}

	public static void download(final String url, final Path path)
		{
		io(() -> Request.Get(url).userAgent(UserAgent).execute().saveContent(path.toFile()));
		}

	public static void io(final FailableRunnable<IOException> function)
		{
		try
			{
			function.run();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	public static <R> R io(final FailableCallable<R, IOException> function)
		{
		try
			{
			return function.call();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
