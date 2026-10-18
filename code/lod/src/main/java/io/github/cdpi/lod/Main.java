package io.github.cdpi.lod;

import java.io.IOException;
import io.github.cdpi.lod.sierre.Sierre;

public final class Main
	{
	private Main()
		{
		throw new UnsupportedOperationException();
		}

	public static void inktober() throws IOException
		{
		//final var path = Path.of("data", "inktober", "prompts.csv");
		//final var calendar = new Inktober().getCalendar(path);
		//System.out.println(calendar);

		/*
		new Inktober().getPrompts().forEach(prompt ->
			{
			System.out.println(prompt.label);
			});
		*/
		}

	public static void sierre() throws IOException
		{
		Sierre.streets();
		}

	public static void main(final String[] args) throws Exception
		{
		//	/home/thefab/Projets/LOD/code/lod/src/main/java/io/github/cdpi/lod/Main.java

		System.out.println("LOD");

		//inktober();
		sierre();

		//System.out.println(new Wikidata().getEntity("Q2").labels);
		}
	}
