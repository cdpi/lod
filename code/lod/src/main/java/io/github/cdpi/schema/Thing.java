package io.github.cdpi.schema;

import com.google.gson.annotations.SerializedName;
import io.github.cdpi.util.LOD;

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
		type = "Thing";
		}

	public Thing(final String name)
		{
		this();

		this.name = name;
		}

	public final String getName()
		{
		return name;
		}

	public static String toString(final Thing thing)
		{
		thing.context = CONTEXT;

		return LOD.toJSON(thing);
		}
	}
