package io.github.cdpi.schema;

import java.util.List;

//list.itemListOrder = 'https://schema.org/ItemListOrderAscending';

public class ItemList<T> extends Thing
	{
	public Integer numberOfItems;
	public List<T> itemListElement;

	public ItemList(final List<T> items)
		{
		super();

		type = "ItemList";
		itemListElement = items;
		numberOfItems = items.size();
		}
	}
