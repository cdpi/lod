package io.github.cdpi.lod.datasets.sierre;

import org.apache.commons.csv.CSVRecord;
import io.github.cdpi.lod.data.CSV;

@Deprecated
public class Stops extends CSV<Stop>
	{
	@Deprecated
	public Stops()
		{
		super(Stops::from);
		}

	/*
	public Stream<Stop> getStops() throws IOException
		{
		return new Stops().parse(Paths.get("data/sierre/bus/stops.csv"));
		}
	*/

	@Deprecated
	public static Stop from(final CSVRecord record)
		{
		final var stop = new Stop();

		stop.slug = record.get(0);
		stop.name = record.get(1);

		return stop;
		}
	}
