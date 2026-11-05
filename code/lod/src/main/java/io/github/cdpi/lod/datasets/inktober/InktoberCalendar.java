package io.github.cdpi.lod.datasets.inktober;

import java.time.temporal.Temporal;
import org.apache.commons.lang3.tuple.Pair;
import io.github.cdpi.lod.data.CSV;

@Deprecated
public class InktoberCalendar extends CSV<Pair<Temporal, String>>
	{
	@Deprecated
	public InktoberCalendar()
		{
		super(null);
		}

	/*
	public Calendar getCalendar(final Stream<Prompt> prompts)
		{
		final var agenda = new Agenda();

		return agenda.of(prompts.map(Prompt::toEvent).toList());
		}

	public Calendar getCalendar(final Stream<Prompt> prompts, final Year year)
		{
		return getCalendar(prompts.filter(Prompt.byYear(year)));
		}
	*/
	}
