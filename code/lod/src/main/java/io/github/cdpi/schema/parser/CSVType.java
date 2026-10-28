package io.github.cdpi.schema.parser;

import java.util.List;

public final class CSVType extends CSVTypeOrProperty<CSVType>
	{
	private String subTypeOf;
	private String enumerationType;
	private String equivalentClass;
	private List<String> properties;
	private List<String> subTypes;

	public String subTypeOf()
		{
		return subTypeOf;
		}

	public CSVType subTypeOf(final String subTypeOf)
		{
		this.subTypeOf = subTypeOf;

		return getThis();
		}

	public String enumerationType()
		{
		return enumerationType;
		}

	public CSVType enumerationType(final String enumerationType)
		{
		this.enumerationType = enumerationType;

		return getThis();
		}

	public String equivalentClass()
		{
		return equivalentClass;
		}

	public CSVType equivalentClass(final String equivalentClass)
		{
		this.equivalentClass = equivalentClass;

		return getThis();
		}

	public List<String> properties()
		{
		return properties;
		}

	public CSVType properties(final List<String> properties)
		{
		this.properties = properties;

		return getThis();
		}

	public List<String> subTypes()
		{
		return subTypes;
		}

	public CSVType subTypes(final List<String> subTypes)
		{
		this.subTypes = subTypes;

		return getThis();
		}
	}
