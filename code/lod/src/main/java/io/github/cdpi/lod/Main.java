package io.github.cdpi.lod;

import java.io.IOException;
import io.github.cdpi.agenda.Agenda;
import io.github.cdpi.inktober.Inktober;
import io.github.cdpi.lod.web.WebSite;
import io.github.cdpi.sierre.Sierre;
import io.github.cdpi.sierre.bus.BusSierrois;
import io.github.cdpi.wikidata.Wikidata;

@SuppressWarnings("unused")
public final class Main
	{
	private Main()
		{
		throw new UnsupportedOperationException();
		}

	public static void inktober()
		{
		//final var calendar = new Inktober().getCalendar();
		//final var agenda = new Agenda();
		//System.out.println(agenda.toString(calendar));

		//new Inktober().getTraductions();
		}

	public static void sierre() throws IOException
		{
		//new Sierre().dev();
		//BusSierrois.dev();
		}

	public static void wikidata()
		{
		final var wikidata = new Wikidata();

		//wikidata.downloadEntity("Q23501"); // tomate
		//wikidata.downloadEntity("Q14088"); // mozzarella
		//wikidata.downloadEntity("Q170486"); // ham (mais c'est jambon en tranches !! pas que jambon)
		//wikidata.downloadEntity("Q188655"); // salami

		//wikidata.dev();
		}

	public static void main(final String[] args)
		{
		try
			{
			//inktober();
			//sierre();
			//wikidata();

			//SchemaOrg.dev();
			//Parser.dev();

			//final var site = new WebSite();
			//site.dev();
			}
		catch (final Throwable ex)
			{
			ex.printStackTrace();
			}
		}
	}
