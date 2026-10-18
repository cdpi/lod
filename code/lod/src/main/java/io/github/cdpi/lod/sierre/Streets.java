package io.github.cdpi.lod.sierre;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.FailableSupplier;
import io.github.cdpi.lod.Util;

public class Streets implements FailableSupplier<Stream<Street>, IOException>
	{
	@Override
	public Stream<Street> get() throws IOException
		{
		throw new UnsupportedOperationException();
		}

	public Stream<Street> get(final Path path) throws IOException
		{
		return Util.csv(path, Street::from);
		}
	}
