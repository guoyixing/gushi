package com.gyx.gushi.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="story_body")
public class Body implements Serializable{

	@Id
	private Long id;
	private Long storyId;
	private String storyBody;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoryId() {
		return storyId;
	}

	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}

	public String getStoryBody() {
		return storyBody;
	}

	public void setStoryBody(String storyBody) {
		this.storyBody = storyBody;
	}
}
