package com.very.youxian.entity;

public class SnsapiUserinfoResponse extends BaseResponse {
	private String openid;
	private String nickname;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	private String privilege;
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public String getNickname() {
		return nickname;
	}

	public String getSex() {
		return sex;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public String getPrivilege() {
		return privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	@Override
	public String toString() {
		return "SnsapiUserinfoResponse [openid=" + openid + ", nickname=" + nickname + ", sex=" + sex + ", province=" + province + ", city=" + city + ", country=" + country + ", headimgurl="
				+ headimgurl + ", privilege=" + privilege + ", unionid=" + unionid + ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

}
