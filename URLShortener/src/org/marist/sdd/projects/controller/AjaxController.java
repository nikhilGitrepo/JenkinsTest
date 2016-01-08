package org.marist.sdd.projects.controller;

import java.util.ArrayList;
import java.util.List;

import org.marist.sdd.projects.cache.ApplicationCache;
import org.marist.sdd.projects.pojo.URL;
import org.marist.sdd.projects.pojo.URLDuo;
import org.marist.sdd.projects.transaction.UrlShortenerServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cedarsoftware.util.io.JsonWriter;

@Controller
public class AjaxController {

	ApplicationCache manager;

	@Autowired
	UrlShortenerServiceDao urlDao;

	@Autowired
	AnnotationConfigApplicationContext ctx;

	private String jsonList;

	@RequestMapping("getrecent.ajax")
	public @ResponseBody String getRecentUrl() {

		List<URL> recentShortUrl = new ArrayList<URL>();

		if (ctx.isActive()) {
			if (ctx.containsBean("getApplicationCacheManager")) {
				manager = ctx.getBean(ApplicationCache.class);
			}
		}
		recentShortUrl = manager.getAccessedUrl();

		jsonList = JsonWriter.objectToJson(recentShortUrl);
		return jsonList;
	}

	@RequestMapping("loadAll.ajax")
	public @ResponseBody String loadAllUrl() {

		if (ctx.isActive()) {
			if (ctx.containsBean("getApplicationCacheManager")) {
				manager = ctx.getBean(ApplicationCache.class);
			}
		}
		
		List<URLDuo> allUrl = manager.loadAllUrl();

		jsonList = JsonWriter.objectToJson(allUrl);
		return jsonList;
	}

}
