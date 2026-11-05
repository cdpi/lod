package io.github.cdpi.lod.data;

public final class LinkedOpenData
	{
	public void process(final DataSet dataset)
		{
		dataset.getDataSources().forEach(source ->
			{
			System.out.println(source.getClass().getCanonicalName());
			System.out.println(source.getPath());
			});
		}

	/*
	public static <T> String tempDataSourceToItemList(final Stream<T> dataSource) throws IOException
		{
		//final var items = stops.map(Stop::toBusStop).toList();
		final var items = dataSource.toList();
		final var list = new ItemList<T>(items);
		return  Thing.toString(list);
		}
	*/
	}
