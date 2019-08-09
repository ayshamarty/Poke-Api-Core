package com.bae.pokeapi.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.pokeapi.persistence.domain.User;

@Service
public class UserServiceImplementation implements UserService {

	private RestTemplate restTemplate;

	public UserServiceImplementation(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public User createUser(User user) {
		ResponseEntity<Object> createdUser = restTemplate.exchange("http://localhost:8083/User/create", HttpMethod.POST,
				null, Object.class);
		User newUser = (User) createdUser.getBody();
		return newUser;

	}

}
