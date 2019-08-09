package com.bae.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.pokeapi.service.SearchService;

@RestController
@RequestMapping("/Search")
public class SearchController {

	public SearchController() {
	}

	public SearchService service;

	@Autowired
	public SearchController(SearchService service) {
		this.service = service;
	}

	@GetMapping("/pokemon/{pokemon}")
	public ResponseEntity<Object> findPokemon(@PathVariable String pokemon) {
		return new ResponseEntity<>(service.findPokemon(pokemon), HttpStatus.OK);
	}

}