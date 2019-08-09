package com.bae.pokeapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.pokeapi.service.SearchService;
import com.bae.pokeapi.service.UserService;

@RestController
@RequestMapping("/Search")
public class SearchController {

	public SearchController() {
	}

	public SearchService searchService;
	public UserService userService;

	@Autowired
	public SearchController(SearchService searchService, UserService userService) {
		this.searchService = searchService;
		this.userService = userService;

	}

	@GetMapping("/{id}/pokemon/{pokemon}")
	public ResponseEntity<Object> findPokemon(@PathVariable Long id, @PathVariable String pokemon) {

		Boolean userCheck = new ResponseEntity<>(userService.checkUser(id), HttpStatus.OK).getBody();

		if (userCheck) {
			Date timeStamp = new Date();
			timeStamp.toLocaleString();
			searchService.sendToQueue(id, pokemon, timeStamp);
			return new ResponseEntity<>(searchService.findPokemon(pokemon), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/{id}/type/{type}")
	public ResponseEntity<Object> findType(@PathVariable Long id, @PathVariable String type) {

		Boolean userCheck = new ResponseEntity<>(userService.checkUser(id), HttpStatus.OK).getBody();

		if (userCheck) {
			return new ResponseEntity<>(searchService.findType(type), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/{id}/ability/{ability}")
	public ResponseEntity<Object> findAbility(@PathVariable Long id, @PathVariable String ability) {

		Boolean userCheck = new ResponseEntity<>(userService.checkUser(id), HttpStatus.OK).getBody();

		if (userCheck) {
			return new ResponseEntity<>(searchService.findAbility(ability), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>("user does not exist", HttpStatus.FORBIDDEN);
		}
	}

}