package io.github.cdpi.api;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.apache.http.client.fluent.Request;

public class ApacheClient implements Client
	{
	//private static final String userAgent = "LOD/0.0.1 (https://github.com/cdpi/lod)";

	@Override
	public String getUserAgent()
		{
		return "LOD/0.0.1 (https://github.com/cdpi/lod)";
		}

	@Override
	public byte[] getAsBytes(URI uri) throws IOException
		{
		return Request.Get(uri).userAgent(getUserAgent()).execute().returnContent().asBytes();
		}

	@Override
	public String getAsString(final URI uri, final Charset charset) throws IOException
		{
		return Request.Get(uri).userAgent(getUserAgent()).execute().returnContent().asString(charset);
		}

	@Override
	public void download(final URI uri, final Path path) throws IOException
		{
		Request.Get(uri).userAgent(getUserAgent()).execute().saveContent(path.toFile());
		}
	}
