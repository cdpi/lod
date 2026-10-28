package io.github.cdpi.api;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public interface Client
	{
	public String getUserAgent();

	public byte[] getAsBytes(URI uri) throws IOException;

	public default byte[] getAsBytes(final String uri) throws IOException
		{
		return getAsBytes(URI.create(uri));
		}

	public String getAsString(URI uri, Charset charset) throws IOException;

	public default String getAsString(final String uri, final Charset charset) throws IOException
		{
		return getAsString(URI.create(uri), charset);
		}

	public default String getAsString(URI uri) throws IOException
		{
		return getAsString(uri, StandardCharsets.UTF_8);
		}

	public default String getAsString(final String uri) throws IOException
		{
		return getAsString(URI.create(uri), StandardCharsets.UTF_8);
		}

	public void download(URI uri, Path path) throws IOException;

	public default void download(final String uri, final Path path) throws IOException
		{
		download(URI.create(uri), path);
		}
	}
