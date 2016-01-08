package org.marist.sdd.projects.controller;

import java.util.List;
import org.marist.sdd.projects.cache.ApplicationCache;
import org.marist.sdd.projects.configuration.AppConfig;
import org.marist.sdd.projects.configuration.ChacheConfig;
import org.marist.sdd.projects.model.ShortUrl;
import org.marist.sdd.projects.pojo.URLHolder;
import org.marist.sdd.projects.transaction.UrlShortenerServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.ehcache.CacheManager;

@Controller
public class URLController {
	private final String resultSuccessPage = "submissionResultSuccess";
	private final String resultFailurePage = "submissionResultFailed"; 
	ApplicationCache manager;

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	@Autowired
	UrlShortenerServiceDao urlDao;
	
	@RequestMapping("redirect.urlview")
	public ModelAndView returnView(){
		ModelAndView mav = new ModelAndView("Home");
		CacheManager.ALL_CACHE_MANAGERS.clear();
		
		if(!ctx.isActive()){
			//AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			if(!ctx.containsBean("getRecentAccessedCacheManager")){
				ctx.register(ChacheConfig.class);
				ctx.register(AppConfig.class);
				ctx.refresh();
			}else if(!ctx.isActive()){
				ctx.register(AppConfig.class);
				ctx.refresh();
			}
		}
		
		return mav;
	}
	
	@RequestMapping("addurl.urlview")
	public ModelAndView shortenNewUrl(@ModelAttribute URLHolder urlHolder){
		ModelAndView mav = new ModelAndView(resultSuccessPage);
		
		if (ctx.isActive()) {
			if (ctx.containsBean("getApplicationCacheManager")) {
				manager = ctx.getBean(ApplicationCache.class);
			}
		}
		
		List<String> allDesiredId = manager.loadAllDesiredId();
		if(allDesiredId.contains(urlHolder.getDesiredId())){
			mav.addObject("newUrlAdded", false);
			mav.setViewName(resultFailurePage);
		}
			
		try {
			ShortUrl shUrl = urlDao.addUrl(urlHolder);
			mav.addObject("shUrl", shUrl);
			mav.addObject("newUrlAdded", true);
			//if there was some error in the creation, then set the failure page as view
			if(!shUrl.isSuccess()){
				mav.setViewName(resultFailurePage);
			}			
		} catch (Exception e) {
			mav.setViewName(resultFailurePage);
			mav.addObject("newUrlAdded", false);
			e.printStackTrace();
		}
		return mav;
	}

}
