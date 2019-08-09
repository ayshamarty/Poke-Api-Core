package com.bae.pokeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.pokeapi.persistence.domain.User;

@Service
public class UserServiceImplementation implements UserService {

	private RestTemplate restTemplate;

	@Autowired
	public UserServiceImplementation(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public User createUser(User user) {

		HttpEntity<User> request = new HttpEntity<>(user);

		ResponseEntity<User> createdUser = restTemplate.exchange("http://localhost:8083/User/create", HttpMethod.POST,
				request, User.class);

		return createdUser.getBody();

	}

	@Override
	public Boolean checkUser(Long id) {
		ResponseEntity<Boolean> userMessage = restTemplate.exchange("http://localhost:8083/User/get/" + id,
				HttpMethod.GET, null, Boolean.class);
		return (Boolean) userMessage.getBody();
	}

}
