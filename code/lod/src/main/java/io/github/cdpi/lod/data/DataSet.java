package io.github.cdpi.lod.data;

import java.util.List;
import org.apache.commons.lang3.NotImplementedException;

public interface DataSet
	{
	public default List<DataSource<?>> getDataSources()
		{
		throw new NotImplementedException();
		}
	}
