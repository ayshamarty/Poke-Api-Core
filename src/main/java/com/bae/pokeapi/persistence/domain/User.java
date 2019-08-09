package com.bae.pokeapi.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String username;
	private String memberNumber;

	public User(Long id, String username, String memberNumber) {
		super();
		this.id = id;
		this.username = username;
		this.memberNumber = memberNumber;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getmemberNumber() {
		return memberNumber;
	}

	public void setmemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
}
