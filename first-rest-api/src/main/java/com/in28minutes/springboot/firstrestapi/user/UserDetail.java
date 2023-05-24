package com.in28minutes.springboot.firstrestapi.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserDetail {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String role;
	
	public UserDetail() {
		
	}
	
	public UserDetail(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
}
