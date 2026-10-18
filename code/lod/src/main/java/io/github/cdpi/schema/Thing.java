package io.github.cdpi.schema;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Thing
	{
	public static final String CONTEXT = "https://schema.org";

	@SerializedName("@context")
	public String context;

	@SerializedName("@type")
	public String type;
	public String name;

	public Thing()
		{
		}

	public Thing(final String name)
		{
		this.name = name;
		}

	public static String toString(final Thing thing)
		{
		thing.context = CONTEXT;

		final var gson = new GsonBuilder().setPrettyPrinting().create();

		return gson.toJson(thing);
		}
	}
