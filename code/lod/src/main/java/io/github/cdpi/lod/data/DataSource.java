package io.github.cdpi.lod.data;

import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;

public interface DataSource<T>
	{
	public default Path getPath()
		{
		throw new NotImplementedException();
		}

	public default Path getPath(final String extension)
		{
		return getPath(getClass(), extension);
		}

	public static Path getPath(final Class<?> clazz, final String extension)
		{
		final var paths = clazz.getPackageName()
			.replace("io.github.cdpi.", "")
			.split("\\.");

		final var filename = clazz.getSimpleName().toLowerCase() + "." + extension;

		return Path.of("data", paths).resolve(filename);
		}
	}
