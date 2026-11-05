package io.github.cdpi.util.ical;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.tuple.Pair;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.immutable.ImmutableCalScale;
import net.fortuna.ical4j.model.property.immutable.ImmutableVersion;
import net.fortuna.ical4j.util.UidGenerator;

public class Generator
	{
	protected final ProdId id;

	public Generator(final ProdId id)
		{
		super();

		this.id = id;
		}

	public Generator(final String id)
		{
		this(new ProdId(id));
		}

	public Calendar of(final List<Pair<Temporal, String>> events, final UidGenerator uidGenerator)
		{
		final var calendar = new Calendar();

		calendar.add(id);

		calendar.add(ImmutableVersion.VERSION_2_0);
		calendar.add(ImmutableCalScale.GREGORIAN);

		events.forEach(event ->
			{
			final var date = event.getLeft();
			final var title = event.getRight();

			final var vEvent = new VEvent(date, title);

			vEvent.add(uidGenerator.generateUid());

			calendar.add(vEvent);
			});

		return calendar;
		}

	public Calendar of(final List<Pair<Temporal, String>> events, final Function<VEvent, Uid> uidGenerator)
		{
		final var calendar = new Calendar();

		calendar.add(id);

		calendar.add(ImmutableVersion.VERSION_2_0);
		calendar.add(ImmutableCalScale.GREGORIAN);

		events.forEach(event ->
			{
			final var date = event.getLeft();
			final var title = event.getRight();

			final var vEvent = new VEvent(date, title);

			vEvent.add(uidGenerator.apply(vEvent));

			calendar.add(vEvent);
			});

		return calendar;
		}

	public String toString(final Calendar calendar, final Writer writer)
		{
		try
			{
			final var output = new CalendarOutputter();

			output.output(calendar, writer);

			return writer.toString();
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	public String toString(final Calendar calendar)
		{
		try (final var writer = new StringWriter())
			{
			return toString(calendar, writer);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}

	public void save(final Calendar calendar, final String path)
		{
		try (final var writer = new FileWriter(path))
			{
			toString(calendar, writer);
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
