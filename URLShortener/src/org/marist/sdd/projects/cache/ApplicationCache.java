/**
 * 
 */
package org.marist.sdd.projects.cache;

import java.util.ArrayList;
import java.util.List;

import org.marist.sdd.projects.pojo.URL;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.transaction.UrlShortenerServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author Nikhil
 *
 */
public class ApplicationCache {
	
	@Autowired
	UrlShortenerServiceDao urlDao;
	
	public ApplicationCache() {
	}

	@Cacheable("serverEhCache")
	public List<URL> getAccessedUrl() {
		List<String> list = urlDao.getRecentUrl();
		
		List<URL> recentShortUrl = new ArrayList<URL>();
		for(String urlString : list){
			recentShortUrl.add(new URL(urlString));
		}
				
		return recentShortUrl;
	}
	
	@Cacheable("allCachedUrl")
	public List<URLDuo> loadAllUrl() {
		return urlDao.loadAllUrl();
	}

	@Cacheable("cachedDesiredId")
	public List<String> loadAllDesiredId() {
		return urlDao.loadAllDesiredId();
	}
	
}
