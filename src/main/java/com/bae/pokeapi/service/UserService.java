package com.bae.pokeapi.service;

import org.springframework.stereotype.Service;

import com.bae.pokeapi.persistence.domain.User;

@Service
public interface UserService {
	public User createUser(User user);

}
