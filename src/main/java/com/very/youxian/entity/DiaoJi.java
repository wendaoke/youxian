package com.very.youxian.entity;

import java.sql.Timestamp;
import java.util.List;

public class DiaoJi {
	private String id;
	private String title;
	private String category;
	private String content;
	private String creator;
	private Timestamp update_time;
	private List<ImageStore> images;
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public String getCreator() {
		return creator;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public List<ImageStore> getImages() {
		return images;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public void setImages(List<ImageStore> images) {
		this.images = images;
	}

}
