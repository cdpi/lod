package io.github.cdpi.api;

import java.io.IOException;
import com.google.gson.Gson;

public class API
	{
	protected static final Gson GSON = new Gson();

	protected final Client client;

	public API(final Client client)
		{
		super();

		this.client = client;
		}

	public <T> T get(final String url, final Class<T> classOfT) throws IOException
		{
		return GSON.fromJson(client.getAsString(url), classOfT);
		}
	}
