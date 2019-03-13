package com.jalal.model;

import java.util.Date;

public class Notes {
	
	private Integer id;
	private String title;
	private String description;
	private Date createddate;
	private Date updateddate;
	
	
	
	public Notes() {
		super();
	}
	public Notes(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedTime() {
		return createddate;
	}
	public void setCreatedTime(Date createdTime) {
		this.createddate = createdTime;
	}
	public Date getUpdatedTime() {
		return updateddate;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updateddate = updatedTime;
	}
}
