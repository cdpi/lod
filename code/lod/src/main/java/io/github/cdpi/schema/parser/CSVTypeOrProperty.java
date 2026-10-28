package io.github.cdpi.schema.parser;

public abstract class CSVTypeOrProperty<T extends CSVTypeOrProperty<T>>
	{
	protected String id;
	protected String label;
	protected String comment;
	protected String supersedes;
	protected String supersededBy;
	protected String isPartOf;

	public final String id()
		{
		return id;
		}

	public final T id(final String id)
		{
		this.id = id;

		return getThis();
		}

	public final String label()
		{
		return label;
		}

	public final T label(final String label)
		{
		this.label = label;

		return getThis();
		}

	public final String comment()
		{
		return comment;
		}

	public final T comment(final String comment)
		{
		this.comment = comment;

		return getThis();
		}

	public final String supersedes()
		{
		return supersedes;
		}

	public final T supersedes(final String supersedes)
		{
		this.supersedes = supersedes;

		return getThis();
		}

	public final String supersededBy()
		{
		return supersededBy;
		}

	public final T supersededBy(final String supersededBy)
		{
		this.supersededBy = supersededBy;

		return getThis();
		}

	public final String isPartOf()
		{
		return isPartOf;
		}

	public final T isPartOf(final String isPartOf)
		{
		this.isPartOf = isPartOf;

		return getThis();
		}

	@SuppressWarnings("unchecked")
	public final T getThis()
		{
		return (T) this;
		}

	@Override
	public String toString()
		{
		return label;
		}
	}
