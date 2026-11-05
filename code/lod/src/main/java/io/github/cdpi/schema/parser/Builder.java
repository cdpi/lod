package io.github.cdpi.schema.parser;

import java.util.Map;

import io.github.cdpi.util.http.ApacheClient;
import io.github.cdpi.util.http.Client;

public final class Builder
	{
	private Client client = new ApacheClient();

	public void build(final Map<String, CSVType> csvTypes, final Map<String, CSVProperty> csvProperties)
		{
		final var x = csvTypes.values().stream()
			.filter(csvType -> csvType.enumerationType() != null)
			.limit(50)
			.map(CSVType::enumerationType)
			.toList();

		System.out.println(x);
		}

	public void build(final String csvTypes, final String csvProperties)
		{
		build(parseTypes(csvTypes), parseProperties(csvProperties));
		}

	public void downloadAndBuild()
		{
		build(downloadTypes(), downloadProperties());
		}

	public String downloadTypes()
		{
		return client.getAsString("https://schema.org/version/latest/schemaorg-current-https-types.csv");
		}

	public String downloadProperties()
		{
		return client.getAsString("https://schema.org/version/latest/schemaorg-current-https-properties.csv");
		}

	public Map<String, CSVType> parseTypes(final String csv)
		{
		return new TypesParser().parse(csv);
		}

	public Map<String, CSVProperty> parseProperties(final String csv)
		{
		return new PropertiesParser().parse(csv);
		}

	public Map<String, CSVType> downloadAndParseTypes()
		{
		return parseTypes(downloadTypes());
		}

	public Map<String, CSVProperty> downloadAndParseProperties()
		{
		return parseProperties(downloadProperties());
		}
	}
