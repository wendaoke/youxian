package com.very.youxian.entity;

import java.sql.Timestamp;
import java.util.List;

public class DiaoHuo {
	private String id;
	private String title;
	private String province;
	private String city;
	private String district;
	private String address;
	private Integer content;
	private Integer status;
	private String creator;
	private Timestamp update_time;
	private List<ImageStore> images;
	private String thumbnail;
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getDistrict() {
		return district;
	}
	public String getAddress() {
		return address;
	}
	public Integer getContent() {
		return content;
	}
	public Integer getStatus() {
		return status;
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
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContent(Integer content) {
		this.content = content;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	

}
