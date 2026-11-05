package io.github.cdpi.util.ical;

import java.util.UUID;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.util.UidGenerator;

public class RandomUID implements UidGenerator
	{
	@Override
	public Uid generateUid()
		{
		return new Uid(UUID.randomUUID().toString());
		}
	}
