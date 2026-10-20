package io.github.cdpi.wikidata.model;

import java.util.Map;

public class Entity
	{
	public Integer pageid;
	public Integer ns;
	public Long lastrevid;
	public String modified;
	public String type;
	public String id;
	public Map<String, Label> labels;
	}
