package io.github.cdpi.lod;

import io.github.cdpi.schema.Thing;
import io.github.cdpi.util.Web;

public class WebSite extends Web
	{
	public WebSite()
		{
		super(getConfiguration("templates", true));
		}

	public void dev()
		{
		final var html = render("simple.ftl", new Thing("THING"));
		System.out.println(html);
		}
	}
