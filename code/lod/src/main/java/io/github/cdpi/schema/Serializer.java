package io.github.cdpi.schema;

import java.lang.reflect.Type;
import org.apache.commons.lang3.NotImplementedException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public final class Serializer
	{
	@SuppressWarnings("unused")
	private JsonSerializer<Property<?>> propertySerializer = new JsonSerializer<Property<?>>()
		{
		@Override
		public JsonElement serialize(Property<?> src, Type typeOfSrc, JsonSerializationContext context)
			{
			throw new NotImplementedException();
			}
		};

	private JsonSerializer<Thing> thingSerializer = new JsonSerializer<Thing>()
		{
		@Override
		public JsonElement serialize(final Thing thing, final Type typeOfThing, final JsonSerializationContext context)
			{
			final var json = new JsonObject();

			//addContext(json);

			/*
			final var types = thing.getTypes().stream()
				.filter(Objects::nonNull)
				.filter(Predicate.not(String::isEmpty))
				.toList();
			*/

			/*
			if (types.size() > 1)
				{
				
				//json.addProperty("@type", new JsonArray());
				final var property = new JsonArray();
				property.add(null);
				json.add("@type", types);
				}
			// Peut avoir plusieurs types
			//"@type": ["HotelRoom","Product"],
			json.addProperty("@type", "Thing");
			*/

			thing.properties.forEach((name, property) ->
				{
				json.addProperty(name, property.toString());
				});

			return json;
			}
		};

	private final Gson GSON = new GsonBuilder()
		.registerTypeAdapter(Thing.class, thingSerializer)
		.setPrettyPrinting()
		.create();

	public String toJSON(final Thing thing)
		{
		//addContext(thing);

		return GSON.toJson(thing, Thing.class);
		}

	/*
	public void addContext(final JsonObject json)
		{
		json.addProperty("@context", "https://schema.org/");
		}
	*/
	}
