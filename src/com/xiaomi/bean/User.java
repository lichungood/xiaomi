package com.xiaomi.bean;

import java.util.Date;

public class User {
	private  int uid;//主键
	private String uname;//姓名
	private int gender;//性别
   private String phone;//电话
   private String area;
   private int manager;//用户身份，默认为1普通用户
   private String username;//账号
   private String password;//密码
   private String photo;//头像
   private Date create_time;//注册日期

	public User() {
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				", uname='" + uname + '\'' +
				", gender=" + gender +
				", phone='" + phone + '\'' +
				", area='" + area + '\'' +
				", manager=" + manager +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", photo='" + photo + '\'' +
				", create_time=" + create_time +
				'}';
	}
}
