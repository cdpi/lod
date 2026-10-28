package io.github.cdpi.lod.web;

import java.io.IOException;
import freemarker.template.TemplateException;

public class WebSite
	{
	protected final Engine engine;

	public WebSite() throws IOException
		{
		engine = new Engine("templates", true);
		}

	public void dev() throws IOException, TemplateException
		{
		//final var html = new WebSite().engine.render("simple.ftl", new Thing("THING"));
		//System.out.println(html);
		}
	}
