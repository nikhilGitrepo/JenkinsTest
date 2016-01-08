package org.marist.sdd.projects.transaction;

import java.util.List;

import org.marist.sdd.projects.pojo.URLDuo;

public interface TransactionManagerDao {
	
	public List<String> getRecentUrl();
	
	public boolean addUrl(URLDuo url);

	public List<URLDuo> loadAllUrl();
	
	public List<String> loadAllDesiredId();

}
