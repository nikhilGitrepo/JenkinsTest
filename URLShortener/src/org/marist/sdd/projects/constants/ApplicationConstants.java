package org.marist.sdd.projects.constants;

public enum ApplicationConstants {
	
	ERROR_URL_CREATION("error_url_creation"),
	SUCCESS_URL_CREATION("success_url_creation"),
	APPLICATION_DOMAIN_NAME("application_domain_name");
	
	public String value;
	
	ApplicationConstants(String value) {

		this.value = value;
	}

	
}
