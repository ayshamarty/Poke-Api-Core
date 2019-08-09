package com.bae.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.pokeapi.persistence.domain.User;
import com.bae.pokeapi.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	public UserController() {
	}

	public UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		service.createUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> checkUser(@PathVariable Long id) {
		return new ResponseEntity<>(service.checkUser(id), HttpStatus.OK);

	}

}