package com.bae.pokeapi.persistence.domain;

import java.util.Date;

public class Search {

	String username;
	String memberNumber;
	String searchTerm;
	Date timeStamp;

	public Search(String username, String memberNumber, String searchTerm, Date timeStamp) {
		super();
		this.username = username;
		this.memberNumber = memberNumber;
		this.searchTerm = searchTerm;
		this.timeStamp = timeStamp;
	}

	public Search() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
