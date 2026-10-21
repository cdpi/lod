package io.github.cdpi.inktober;

import java.time.LocalDate;
import java.time.Year;
import java.util.function.Predicate;
import org.apache.commons.csv.CSVRecord;
import io.github.cdpi.agenda.Entry;

public class Prompt implements Entry
	{
	protected LocalDate date;
	protected String prompt;

	@Override
	public LocalDate getDate()
		{
		return date;
		}

	@Override
	public String getSummary()
		{
		return getPrompt();
		}

	public String getPrompt()
		{
		return prompt;
		}

	public Entry toEntry()
		{
		return this;
		}

	public static Predicate<Prompt> byYear(final int year)
		{
		return prompt -> prompt.date.getYear() == year;
		}

	public static Predicate<Prompt> byYear(final Year year)
		{
		return byYear(year.getValue());
		}

	public static Prompt from(final CSVRecord record)
		{
		final var prompt = new Prompt();

		prompt.date = LocalDate.parse(record.get(0));
		prompt.prompt = record.get(1);

		return prompt;
		}
	}
