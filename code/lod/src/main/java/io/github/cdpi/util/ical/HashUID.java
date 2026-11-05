package io.github.cdpi.util.ical;

import java.util.function.Function;
import io.github.cdpi.util.Hash;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Uid;

public final class HashUID implements Function<VEvent, Uid>
	{
	private final Hash hash;

	public HashUID(final Hash hash)
		{
		super();

		this.hash = hash;
		}

	@Override
	public Uid apply(final VEvent vEvent)
		{
		final var date = vEvent.getDateTimeStart().getDate().toString();
		final var summary = vEvent.getSummary().getValue();

		return new Uid(hash.hash(date + summary));
		}
	}
