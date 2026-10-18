package io.github.cdpi.schema;

public class ListItem extends Thing
	{
	public Integer position;

	public ListItem(final String name, final Integer position)
		{
		super(name);

		type = "ListItem";

		this.position = position;
		}
	}
