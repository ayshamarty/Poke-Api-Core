package com.bae.pokeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchServiceImplementation implements SearchService {

	private RestTemplate restTemplate;

	@Autowired
	public SearchServiceImplementation(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Object findPokemon(String pokemon) {
		ResponseEntity<Object> pokemonFound = restTemplate
				.exchange("http://localhost:8082/Source/getPokemon/" + pokemon, HttpMethod.GET, null, Object.class);
		return pokemonFound.getBody();
	}

	@Override
	public Object findType(String type) {
		ResponseEntity<Object> typeFound = restTemplate.exchange("http://localhost:8082/Source/getPokemon/" + type,
				HttpMethod.GET, null, Object.class);
		return typeFound.getBody();
	}

	@Override
	public Object findAbility(String ability) {
		ResponseEntity<Object> abilityFound = restTemplate
				.exchange("http://localhost:8082/Source/getPokemon/" + ability, HttpMethod.GET, null, Object.class);
		return abilityFound.getBody();
	}

}
