package com.very.youxian.entity;

import java.sql.Timestamp;

public class Comment {
	private String id;
	private int type;
	private String item_id;
	private String content;
	private String commentator_id;
	private String commentator_name;
	private String commentator_headimg;
	private Timestamp update_time;

	public String getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public String getItem_id() {
		return item_id;
	}

	public String getContent() {
		return content;
	}

	public String getCommentator_id() {
		return commentator_id;
	}

	public String getCommentator_name() {
		return commentator_name;
	}

	public String getCommentator_headimg() {
		return commentator_headimg;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCommentator_id(String commentator_id) {
		this.commentator_id = commentator_id;
	}

	public void setCommentator_name(String commentator_name) {
		this.commentator_name = commentator_name;
	}

	public void setCommentator_headimg(String commentator_headimg) {
		this.commentator_headimg = commentator_headimg;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

}
