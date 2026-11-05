package io.github.cdpi.lod.datasets.inktober;

import java.util.List;
import io.github.cdpi.lod.data.DataSet;
import io.github.cdpi.lod.data.DataSource;

@Deprecated
public class Inktober implements DataSet
	{
	@Deprecated
	@Override
	public List<DataSource<?>> getDataSources()
		{
		return List.of(new InktoberCalendar());
		}

	/*
	public List<Prompt> getPrompts(final Path path) throws IOException
		{
		return parse(path);
		}

	public List<Prompt> getPrompts()
		{
		//return getPrompts(getDataPath("inktober", "prompts.csv"));
	
		throw new UnsupportedOperationException();
		}
	*/

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
