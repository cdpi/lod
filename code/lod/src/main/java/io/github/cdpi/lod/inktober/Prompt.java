package io.github.cdpi.lod.inktober;

import java.time.LocalDate;
import org.apache.commons.csv.CSVRecord;
import io.github.cdpi.agenda.Entry;

public class Prompt implements Entry
	{
	public LocalDate date;
	public String label;

	@Override
	public LocalDate getDate()
		{
		return date;
		}

	@Override
	public String getSummary()
		{
		return label;
		}

	public static Prompt from(final CSVRecord record)
		{
		final var prompt = new Prompt();

		prompt.date = LocalDate.parse(record.get(0));
		prompt.label = record.get(1);

		return prompt;
		}
	}
