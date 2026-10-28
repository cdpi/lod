package io.github.cdpi.geo;

public class Street
	{
	public String slug;
	public String name;
	public Integer osm;

	/*
	public AdministrativeArea toAdministrativeArea()
		{
		final var administrativeArea = new AdministrativeArea(name);

		return  administrativeArea;
		}

	public static String toItemList(final Stream<Street> streets)
		{
		final var things = streets.map(Street::toAdministrativeArea).toList();

		final var list = new ItemList<>(things);

		return Thing.toString(list);
		}

	public static Street from(final CSVRecord record)
		{
		final var street = new Street();

		street.slug = record.get(0);

		street.name = record.get(1);

		if (record.isSet(2) && !record.get(2).isEmpty())
			{
			street.osm = Integer.parseInt(record.get(2));
			}

		return street;
		}
	*/
	}
