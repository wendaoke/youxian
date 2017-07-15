package com.very.youxian.entity;

public class UserExtraInfo {
	private String id;
	private String userid;
	private String birthday;
	private String phone;
	private String postcode;
	private String address;
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getPhone() {
		return phone;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
