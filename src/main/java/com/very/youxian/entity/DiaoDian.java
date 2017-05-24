package com.very.youxian.entity;

import java.util.List;

public class DiaoDian {
	private String id;
	private String province;
	private String city;
	private String district;
	private String name;
	private String address;
	private Integer type;
	private Integer is_charge;
	private String charge_desc;
	private String contact_person;
	private String contact_number;
	private String fish_type;
	private String fish_desc;

	private List<DiaoDianImage> images;
	
	public String getId() {
		return id;
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

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Integer getType() {
		return type;
	}

	public Integer getIs_charge() {
		return is_charge;
	}

	public String getCharge_desc() {
		return charge_desc;
	}

	public String getContact_person() {
		return contact_person;
	}

	public String getContact_number() {
		return contact_number;
	}

	public String getFish_type() {
		return fish_type;
	}

	public String getFish_desc() {
		return fish_desc;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setIs_charge(Integer is_charge) {
		this.is_charge = is_charge;
	}

	public void setCharge_desc(String charge_desc) {
		this.charge_desc = charge_desc;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public void setFish_type(String fish_type) {
		this.fish_type = fish_type;
	}

	public void setFish_desc(String fish_desc) {
		this.fish_desc = fish_desc;
	}
	public List<DiaoDianImage> getImages() {
		return images;
	}

	public void setImages(List<DiaoDianImage> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "DiaoDian [id=" + id + ", province=" + province + ", city=" + city + ", district=" + district + ", name=" + name + ", address=" + address + ", type=" + type + ", is_charge=" + is_charge
				+ ", charge_desc=" + charge_desc + ", contact_person=" + contact_person + ", contact_number=" + contact_number + ", fish_type=" + fish_type + ", fish_desc=" + fish_desc + ", images="
				+ images + "]";
	}


}
