package io.github.cdpi.lod;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import io.github.cdpi.agenda.Agenda;

public class Inktober
	{
	public String getCalendar() throws IOException
		{
		final var agenda = new Agenda();

		final var calendar = agenda.of(LocalDate.of(2026, Month.OCTOBER, 1), "Pomme");

		return agenda.toString(calendar);
		}
	}
