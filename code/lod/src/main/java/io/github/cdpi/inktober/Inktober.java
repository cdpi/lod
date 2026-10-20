package io.github.cdpi.inktober;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Year;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVRecord;
import io.github.cdpi.agenda.Agenda;
import io.github.cdpi.agenda.Entry;
import io.github.cdpi.util.CSV;
import io.github.cdpi.util.LOD;
import net.fortuna.ical4j.model.Calendar;

public class Inktober extends LOD
	{
	public Stream<Prompt> getPrompts(final Path path)
		{
		return CSV.parse(path, Inktober.Prompt::from);
		}

	public Stream<Prompt> getPrompts()
		{
		return getPrompts(getDataPath("inktober", "prompts.csv"));
		}

	public Calendar getCalendar(final Stream<Prompt> prompts)
		{
		final var agenda = new Agenda();

		return agenda.of(prompts.map(prompt -> (Entry) prompt).toList());
		}

	public Calendar getCalendar(final Path path)
		{
		return getCalendar(getPrompts(path));
		}

	public Calendar getCalendar()
		{
		return getCalendar(getPrompts());
		}

	public String getCalendar(final Year year)
		{
		throw new UnsupportedOperationException();
		}

	public static class Prompt extends Entry
		{
		public static Prompt from(final CSVRecord record)
			{
			final var prompt = new Prompt();

			prompt.date = LocalDate.parse(record.get(0));
			prompt.summary = record.get(1);

			return prompt;
			}
		}
	}
