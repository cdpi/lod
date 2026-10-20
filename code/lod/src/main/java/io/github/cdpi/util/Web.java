package io.github.cdpi.util;

import java.io.File;
import java.io.StringWriter;
import org.apache.commons.lang3.exception.UncheckedException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class Web extends LOD
	{
	protected final Configuration configuration;

	public Web(final Configuration configuration)
		{
		super();

		this.configuration = configuration;
		}

	public Web(final String templatesDirectory)
		{
		this(getConfiguration(templatesDirectory));
		}

	public Web(final String templatesDirectory, final boolean debug)
		{
		this(getConfiguration(templatesDirectory, debug));
		}

	public <T> String render(final String templateName, final T model)
		{
		return io(() ->
			{
			try (final var writer = new StringWriter())
				{
				final var template = configuration.getTemplate(templateName);

				template.process(model, writer);

				return writer.toString();
				}
			catch (final TemplateException ex)
				{
				throw new UncheckedException(ex);
				}
			});
		}

	public static Configuration getConfiguration(final String templatesDirectory, final boolean debug)
		{
		return io(() ->
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
			});
		}

	public static Configuration getConfiguration(final String templatesDirectory)
		{
		return getConfiguration(templatesDirectory, false);
		}
	}
