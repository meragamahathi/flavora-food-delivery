package com.food.model;

import java.sql.Timestamp;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String role;
	private String status;
	private Timestamp createDate;
	private Timestamp lastLoginDate;
	public User() {
		
	}
	
	
	public User(String userName, String email,String password,String role,String address) {
		this.userName = userName;
		this.email = email;
		this.password=password;
		this.role=role;
		this.address = address;
	}

	

	public User(int userId, String userName, String password, String email, String address, String role,String status,
			Timestamp createDate, Timestamp lastLoginDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.status = status;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}


	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

	
    

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + ", status=" + status + ", createDate=" + createDate
				+ ", lastLoginDate=" + lastLoginDate + "]";
	}


	public static void main(String[] args) {
		

	}

}
