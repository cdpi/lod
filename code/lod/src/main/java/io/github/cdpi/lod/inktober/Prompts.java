package io.github.cdpi.lod.inktober;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.apache.commons.lang3.function.FailableSupplier;
import io.github.cdpi.lod.Util;

public class Prompts implements FailableSupplier<Stream<Prompt>, IOException>
	{
	@Override
	public Stream<Prompt> get() throws IOException
		{
		throw new UnsupportedOperationException();
		}

	public Stream<Prompt> get(final Path path) throws IOException
		{
		return Util.csv(path, Prompt::from);
		}
	}
