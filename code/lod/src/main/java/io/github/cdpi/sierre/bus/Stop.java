package io.github.cdpi.sierre.bus;

public class Stop
	{
	protected String slug;
	protected String name;

	public String getName()
		{
		return name;
		}

	public String getSlug()
		{
		return slug;
		}

	/*
	public BusStop toBusStop()
		{
		return new BusStop(name);
		}

	public static Stop from(final CSVRecord record)
		{
		final var stop = new Stop();

		stop.slug = record.get(0);
		stop.name = record.get(1);

		return stop;
		}
	*/
	}
