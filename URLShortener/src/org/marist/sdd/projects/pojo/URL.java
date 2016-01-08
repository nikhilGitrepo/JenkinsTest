package org.marist.sdd.projects.pojo;

import java.io.Serializable;

public class URL implements Serializable{
	private static final long serialVersionUID = 1L;
	private String url;
	private String domainType;

	public URL() {
	}

	public URL(String url) {
		this.url = url;
	}
	
	public URL(String url, String domainType) {
		super();
		this.url = url;
		this.domainType = domainType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDomainType() {
		return domainType;
	}

	public void setDomainType(String domainType) {
		this.domainType = domainType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainType == null) ? 0 : domainType.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		URL other = (URL) obj;
		if (domainType == null) {
			if (other.domainType != null)
				return false;
		} else if (!domainType.equals(other.domainType))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	/*@Override
	public String toString() {
		return "URL [url=" + url + ", domainType=" + domainType + "]";
	}
	*/
}
