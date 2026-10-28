package io.github.cdpi.lod.web;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class Engine
	{
	protected final Configuration configuration;

	public Engine(final Configuration configuration)
		{
		super();

		this.configuration = configuration;
		}

	public Engine(final String templatesDirectory) throws IOException
		{
		this(getConfiguration(templatesDirectory));
		}

	public Engine(final String templatesDirectory, final boolean debug) throws IOException
		{
		this(getConfiguration(templatesDirectory, debug));
		}

	public <T> String render(final String templateName, final T model) throws IOException, TemplateException
		{
		try (final var writer = new StringWriter())
			{
			final var template = configuration.getTemplate(templateName);

			template.process(model, writer);

			return writer.toString();
			}
		}

	public static Configuration getConfiguration(final String templatesDirectory, final boolean debug) throws IOException
		{
		final var configuration = new Configuration(Configuration.VERSION_2_3_35);

		configuration.setDirectoryForTemplateLoading(new File(templatesDirectory));

		configuration.setDefaultEncoding("UTF-8");

		if (debug)
			{
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
			}
		else
			{
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			}

		configuration.setLogTemplateExceptions(false);

		configuration.setWrapUncheckedExceptions(true);

		configuration.setFallbackOnNullLoopVariable(false);

		//cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

		return configuration;
		}

	public static Configuration getConfiguration(final String templatesDirectory) throws IOException
		{
		return getConfiguration(templatesDirectory, false);
		}
	}
