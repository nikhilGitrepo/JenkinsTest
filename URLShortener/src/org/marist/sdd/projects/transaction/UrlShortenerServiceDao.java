package org.marist.sdd.projects.transaction;

import java.util.List;

import org.marist.sdd.projects.model.ShortUrl;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.pojo.URLHolder;

public interface UrlShortenerServiceDao {
	
	public List<String> getRecentUrl();
	
	public ShortUrl addUrl(URLHolder urlholder);

	public List<URLDuo> loadAllUrl();
	
	public List<String> loadAllDesiredId();

}
