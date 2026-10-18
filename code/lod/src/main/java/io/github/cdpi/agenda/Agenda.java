package io.github.cdpi.agenda;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.immutable.ImmutableCalScale;
import net.fortuna.ical4j.model.property.immutable.ImmutableVersion;
import net.fortuna.ical4j.util.UidGenerator;

public class Agenda implements UidGenerator
	{
	public Calendar of(final LocalDate date, final String summary)
		{
		final var calendar = new Calendar();

		calendar.add(new ProdId("-//CDPI//LOD 0.0.1//FR"));
		calendar.add(ImmutableVersion.VERSION_2_0);
		calendar.add(ImmutableCalScale.GREGORIAN);

		final var event = new VEvent(date, summary);

		event.add(generateUid());

		calendar.add(event);

		return calendar;
		}

	public Calendar of(final List<Entry> entries)
		{
		final var calendar = new Calendar();

		calendar.add(new ProdId("-//CDPI//LOD 0.0.1//FR"));
		calendar.add(ImmutableVersion.VERSION_2_0);
		calendar.add(ImmutableCalScale.GREGORIAN);

		entries.forEach(entry ->
			{
			final var event = new VEvent(entry.getDate(), entry.getSummary());

			event.add(generateUid());

			calendar.add(event);
			});

		return calendar;
		}

	public String toString(final Calendar calendar) throws IOException
		{
		try (final var writer = new StringWriter())
			{
			final var output = new CalendarOutputter();

			output.output(calendar, writer);

			return writer.toString();
			}
		}

	//FileOutputStream fout = new FileOutputStream("mycalendar.ics");

	@Override
	public Uid generateUid()
		{
		return new Uid(UUID.randomUUID().toString());
		}
	}
