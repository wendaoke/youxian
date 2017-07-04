package com.very.youxian.entity;

import java.sql.Timestamp;
import java.util.List;

import com.very.youxian.util.DateUtil;

public class SecondHand {
	private String id;
	private String title;
	private String content;
	private String province;
	private String city;
	private String area;
	private String address;
	private String contactWay;
	private String contactInfo;
	private int status;
	private String creator;
	private Timestamp update_time;
	private String upateTime;
	private List<ImageStore> images;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getArea() {
		return area;
	}

	public String getAddress() {
		return address;
	}

	public String getContactWay() {
		return contactWay;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public int getStatus() {
		return status;
	}

	public String getCreator() {
		return creator;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}


	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public List<ImageStore> getImages() {
		return images;
	}

	public void setImages(List<ImageStore> images) {
		this.images = images;
	}

	public String getUpateTime() {
		return DateUtil.getStringFromTimeStamp(update_time);
	}

	public void setUpateTime(String upateTime) {
		this.upateTime = upateTime;
	}

}
