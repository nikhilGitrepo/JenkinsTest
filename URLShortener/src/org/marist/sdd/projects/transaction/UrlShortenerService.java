package org.marist.sdd.projects.transaction;

import java.util.List;

import javax.transaction.Transactional;

import org.marist.sdd.projects.constants.ApplicationConstants;
import org.marist.sdd.projects.model.ShortUrl;
import org.marist.sdd.projects.pojo.URL;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.pojo.URLHolder;
import org.marist.sdd.projects.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Status;

@Service("urlShortenerService")
@Transactional
@PropertySource(value = { "classpath:/application.properties" })
public class UrlShortenerService extends HibernateUtil  implements UrlShortenerServiceDao{

	@Autowired
	TransactionManagerDao transactionDao;
	
    @Autowired
    private Environment environment;
	
	@Override
	public List<String> getRecentUrl() {
		return transactionDao.getRecentUrl();
	}

	@Override
	public ShortUrl addUrl(URLHolder urlholder) {
		
		URLDuo url = new URLDuo(urlholder.getLongUrl().getUrl(), 
									urlholder.getDesiredId(),
									environment.getRequiredProperty(ApplicationConstants.APPLICATION_DOMAIN_NAME.value)
										 + urlholder.getDesiredId());

		boolean result = transactionDao.addUrl(url);
		ShortUrl shortUrl = new ShortUrl();
		if(result){
			shortUrl.setMessage(environment.getRequiredProperty(ApplicationConstants.SUCCESS_URL_CREATION.value));
			shortUrl.setShortUrl(new URL( url.getShortUrl() ));
			
			if(net.sf.ehcache.CacheManager.getInstance().getCache("serverEhCache").getStatus().equals(Status.STATUS_ALIVE) && 
					net.sf.ehcache.CacheManager.getInstance().getCache("allCachedUrl").getStatus().equals(Status.STATUS_ALIVE)){
				
				net.sf.ehcache.CacheManager.getInstance().clearAllStartingWith("serverEhCache");
				net.sf.ehcache.CacheManager.getInstance().clearAllStartingWith("allCachedUrl");
				net.sf.ehcache.CacheManager.getInstance().clearAllStartingWith("cachedDesiredId");
				
			}
			
		}else{
			shortUrl.setMessage(environment.getRequiredProperty(ApplicationConstants.ERROR_URL_CREATION.value));
		}
		shortUrl.setError(result);
		return shortUrl;
	}

	@Override
	public List<URLDuo> loadAllUrl() {
		return transactionDao.loadAllUrl();
	}

	@Override
	public List<String> loadAllDesiredId() {
		return transactionDao.loadAllDesiredId();
	}
	
}
