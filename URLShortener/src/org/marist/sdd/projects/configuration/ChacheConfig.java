/**
 * 
 */
package org.marist.sdd.projects.configuration;

import org.marist.sdd.projects.cache.ApplicationCache;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.Status;

@Configurable
@EnableCaching
@ComponentScan("org.marist.sdd.projects.configuration")
public class ChacheConfig {

	@Bean
	public ApplicationCache getApplicationCacheManager(){
		return new ApplicationCache();
	}
	
	@Bean
	public CacheManager getEhCacheManager(){
		if(net.sf.ehcache.CacheManager.getInstance().getCache("serverEhCache").getStatus().equals(Status.STATUS_ALIVE)){
			return new EhCacheCacheManager( net.sf.ehcache.CacheManager.getInstance() );
		}else{
			return new EhCacheCacheManager( getEhCacheFactory().getObject() );
		}
	}
	
	@Bean
	public EhCacheManagerFactoryBean getEhCacheFactory(){
		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factoryBean.setShared(true);
		return factoryBean;
	}
}
