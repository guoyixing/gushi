package com.gyx.gushi.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="access")
public class Access implements Serializable{

	@Id
	private Long id;
	private String ip;
	private java.util.Date accessTime;
	private String accessStory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	public String getAccessStory() {
		return accessStory;
	}

	public void setAccessStory(String accessStory) {
		this.accessStory = accessStory;
	}
}
