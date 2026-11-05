package io.github.cdpi.util.http;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;

public interface Client
	{
	public static final String LOD_USER_AGENT = "LOD/0.0.1 (https://github.com/cdpi/lod)";

	public default String getUserAgent()
		{
		return LOD_USER_AGENT;
		}

	public default byte[] getAsBytes(final URI uri)
		{
		throw new NotImplementedException("getAsBytes");
		}

	public default byte[] getAsBytes(final String uri)
		{
		return getAsBytes(URI.create(uri));
		}

	public default String getAsString(final URI uri, final Charset charset)
		{
		throw new NotImplementedException("getAsString");
		}

	public default String getAsString(final String uri, final Charset charset)
		{
		return getAsString(URI.create(uri), charset);
		}

	public default String getAsString(final URI uri)
		{
		return getAsString(uri, StandardCharsets.UTF_8);
		}

	public default String getAsString(final String uri)
		{
		return getAsString(URI.create(uri));
		}

	public default void download(final URI uri, final Path path)
		{
		throw new NotImplementedException("download");
		}

	public default void download(final String uri, final Path path)
		{
		download(URI.create(uri), path);
		}
	}
