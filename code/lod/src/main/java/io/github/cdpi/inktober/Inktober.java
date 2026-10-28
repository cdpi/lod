package io.github.cdpi.inktober;

import java.nio.file.Path;
import java.util.stream.Stream;
import io.github.cdpi.util.CSV;

@SuppressWarnings("deprecation")
public class Inktober extends CSV
	{
	public Stream<Prompt> getPrompts(final Path path)
		{
		return parse(path, Prompt::from);
		}

	public Stream<Prompt> getPrompts()
		{
		return getPrompts(getDataPath("inktober", "prompts.csv"));
		}

	/*
	public void getTraductions()
		{
		final var fr1 = getListOfString(getDataPath("inktober", "2026-fr.csv"));
		final var fr2 = getListOfString(getDataPath("inktober", "2026-fr-2.csv"));
		final var frDeepL = getListOfString(getDataPath("inktober", "2026-fr-deepl.csv"));

		final var traductions = getPrompts()
			.filter(prompt -> prompt.date.getYear() == 2026)
			.map(prompt ->
				{
				final var index = prompt.date.getDayOfMonth() - 1;

				final var traduction = new ArrayList<String>();

				traduction.add(prompt.summary);
				traduction.add(fr1.get(index));
				traduction.add(fr2.get(index));
				traduction.add(frDeepL.get(index));

				return traduction;
				})
			.toList();

		System.out.println(toJSON(traductions));
		}
	*/
	}
