package io.github.cdpi.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Function;
import org.apache.commons.lang3.exception.UncheckedException;

public abstract class Hash implements Function<String, String>
	{
	protected final MessageDigest digest;

	public Hash(final String algorithm)
		{
		super();

		try
			{
			digest = MessageDigest.getInstance(algorithm);
			}
		catch (final NoSuchAlgorithmException ex)
			{
			throw new UncheckedException(ex);
			}
		}

	@Override
	public String apply(final String value)
		{
		return hash(value);
		}

	public String hash(final String value)
		{
		final var bytes = digest.digest(value.getBytes(StandardCharsets.UTF_8));

		final var builder = new StringBuilder(bytes.length * 2);

		for (final var b : bytes)
			{
			builder.append(String.format("%02x", b));
			}

		return builder.toString();
		}
	}
