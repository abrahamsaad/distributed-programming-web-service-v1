package com.uninorte.distributed.programming.web.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "t1_user")
public class User {
	
	@Id
	private Integer user_id;
	@Column
	private String user_name;
	@Column
	private String user_password_sha256;
	@Column
	private String user_email;
	
	public User() {
		
	}

	
	public User(int user_id, String user_name, String user_password_sha256, String user_email) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password_sha256 = user_password_sha256;
		this.user_email = user_email;
	
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password_sha256() {
		return user_password_sha256;
	}

	public void setUser_password_sha256(String user_password_sha256) {
		this.user_password_sha256 = user_password_sha256;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password_sha256="
				+ user_password_sha256 + ", user_email=" + user_email + "]";
	}

	
	
	
	
	

}
