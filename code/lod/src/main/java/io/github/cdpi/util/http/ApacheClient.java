package io.github.cdpi.util.http;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Path;

import org.apache.http.client.fluent.Request;

public class ApacheClient implements Client
	{
	@Override
	public byte[] getAsBytes(final URI uri)
		{
		try
			{
			return Request.Get(uri)
				.userAgent(getUserAgent())
				.execute()
				.returnContent()
				.asBytes();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	@Override
	public String getAsString(final URI uri, final Charset charset)
		{
		try
			{
			return Request.Get(uri)
				.userAgent(getUserAgent())
				.execute()
				.returnContent()
				.asString(charset);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	@Override
	public void download(final URI uri, final Path path)
		{
		try
			{
			Request.Get(uri)
				.userAgent(getUserAgent())
				.execute()
				.saveContent(path.toFile());
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
