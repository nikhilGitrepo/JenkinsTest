/**
 * 
 */
package org.marist.sdd.projects.model;

import java.io.Serializable;

import org.marist.sdd.projects.pojo.URL;

/**
 * @author Nik
 *
 */
public class ShortUrl implements Serializable{

	private static final long serialVersionUID = 1L;

	private URL shortUrl;
	private boolean error;
	private String message;

	public ShortUrl(URL shortUrl, boolean error, String message) {
		this.shortUrl = shortUrl;
		this.error = error;
		this.message = message;
	}
	
	public ShortUrl(URL shortUrl) {
		this.shortUrl = shortUrl;
	}

	public ShortUrl() {
	}

	public URL getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(URL shortUrl) {
		this.shortUrl = shortUrl;
	}

	public boolean isSuccess() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
