package io.github.cdpi.inktober;

import java.time.Year;
import java.util.stream.Stream;
import io.github.cdpi.agenda.Agenda;
import net.fortuna.ical4j.model.Calendar;

public class InktoberCalendar extends Inktober
	{
	public Calendar getCalendar(final Stream<Prompt> prompts)
		{
		final var agenda = new Agenda();

		return agenda.of(prompts.map(Prompt::toEntry).toList());
		}

	public Calendar getCalendar(final Stream<Prompt> prompts, final Year year)
		{
		return getCalendar(prompts.filter(Prompt.byYear(year)));
		}
	}
