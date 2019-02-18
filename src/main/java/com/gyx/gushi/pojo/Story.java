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
@Table(name="story")
public class Story implements Serializable{

	@Id
	private Long id;


	
	private String name;
	private Long storyBodyId;
	private Date createDate;
	private String storyType;
	private int readNum;
	private String storyImage;
	private String storyProfile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStoryBodyId() {
		return storyBodyId;
	}

	public void setStoryBodyId(Long storyBodyId) {
		this.storyBodyId = storyBodyId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStoryType() {
		return storyType;
	}

	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public String getStoryImage() {
		return storyImage;
	}

	public void setStoryImage(String storyImage) {
		this.storyImage = storyImage;
	}

	public String getStoryProfile() {
		return storyProfile;
	}

	public void setStoryProfile(String storyProfile) {
		this.storyProfile = storyProfile;
	}
}
