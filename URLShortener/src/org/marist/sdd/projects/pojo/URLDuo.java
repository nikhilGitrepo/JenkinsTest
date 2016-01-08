/**
 * 
 */
package org.marist.sdd.projects.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Nik
 *
 */
@Entity
@Table(name="URLDuo")
@NamedQueries({
	@NamedQuery(
	name = "findAllUrlsINDatabase",
	query = "from URLDuo"
	)
})
public class URLDuo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int longUrlId;
	private String longUrl;
	private String desiredId;
	
	private String shortUrl;
	private Date dateCreated;
	
	public URLDuo() {
	}

	public URLDuo(String longUrl, String desiredId, String shortUrlnew) {
		this.longUrl = longUrl;
		this.desiredId = desiredId;
		this.shortUrl = shortUrlnew;
		this.dateCreated = new Date();
	}

	public URLDuo(int longUrlId, String longUrl, String desiredId) {
		this.longUrlId = longUrlId;
		this.longUrl = longUrl;
		this.desiredId = desiredId;
	}

	@Id
	@GeneratedValue
	public int getLongUrlId() {
		return longUrlId;
	}

	public void setLongUrlId(int longUrlId) {
		this.longUrlId = longUrlId;
	}

	@Column
	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	@Column
	public String getDesiredId() {
		return desiredId;
	}

	public void setDesiredId(String desiredId) {
		this.desiredId = desiredId;
	}

	@Column
	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	@Column
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desiredId == null) ? 0 : desiredId.hashCode());
		result = prime * result + ((longUrl == null) ? 0 : longUrl.hashCode());
		result = prime * result + longUrlId;
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
		URLDuo other = (URLDuo) obj;
		if (desiredId == null) {
			if (other.desiredId != null)
				return false;
		} else if (!desiredId.equals(other.desiredId))
			return false;
		if (longUrl == null) {
			if (other.longUrl != null)
				return false;
		} else if (!longUrl.equals(other.longUrl))
			return false;
		if (longUrlId != other.longUrlId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongUrl [longUrlId=" + longUrlId + ", longUrl=" + longUrl + ", desiredId=" + desiredId + "]";
	}

}
