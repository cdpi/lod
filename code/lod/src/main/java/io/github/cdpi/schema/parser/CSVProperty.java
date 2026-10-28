package io.github.cdpi.schema.parser;

public final class CSVProperty extends CSVTypeOrProperty<CSVProperty>
	{
	private String subPropertyOf;
	/*
	private String equivalentProperty;
	private String subproperties;
	private String domainIncludes;
	private String rangeIncludes;
	private String inverseOf;
	*/

	public String subPropertyOf()
		{
		return subPropertyOf;
		}

	public CSVProperty setSubPropertyOf(final String subPropertyOf)
		{
		this.subPropertyOf = subPropertyOf;

		return getThis();
		}
	}
