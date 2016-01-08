package org.marist.sdd.projects.pojo;

public class URLHolder {

	private URL longUrl;
	private String desiredId;

	public URLHolder() {
	}
	
	public URLHolder(URL longUrl, String desiredId) {
		super();
		this.longUrl = longUrl;
		this.desiredId = desiredId;
	}
	
	public URL getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(URL longUrl) {
		this.longUrl = longUrl;
	}
	public String getDesiredId() {
		return desiredId;
	}
	public void setDesiredId(String desiredId) {
		this.desiredId = desiredId;
	}
	@Override
	public String toString() {
		return "URLHolder [longUrl=" + longUrl + ", desiredId=" + desiredId + "]";
	}
	
}
