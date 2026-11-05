package io.github.cdpi.util.http;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import org.apache.commons.lang3.exception.UncheckedException;

public class JavaClient implements Client
	{
	protected final HttpClient client;

	public JavaClient()
		{
		super();

		client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
		}

	@Override
	public String getAsString(final URI uri, final Charset charset)
		{
		try
			{
			final var request = HttpRequest.newBuilder()
				.GET()
				.uri(uri)
				.header("User-Agent", getUserAgent())
				.build();

			final var response = client.send(request, HttpResponse.BodyHandlers.ofString(charset));

			return response.body();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		catch (final InterruptedException ex)
			{
			throw new UncheckedException(ex);
			}
		}
	}
