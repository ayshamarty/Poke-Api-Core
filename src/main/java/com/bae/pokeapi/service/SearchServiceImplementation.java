package com.bae.pokeapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.pokeapi.persistence.domain.Search;
import com.bae.pokeapi.persistence.domain.User;

@Service
public class SearchServiceImplementation implements SearchService {

	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	@Autowired
	public SearchServiceImplementation(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
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

	public void sendToQueue(Long id, String searchTerm, Date timeStamp) {
		User user = getUser(id);
		Search searchDetails = new Search(user.getUsername(), user.getmemberNumber(), searchTerm, timeStamp);
		jmsTemplate.convertAndSend("SearchQueue", searchDetails);
	}

	public User getUser(Long id) {
		ResponseEntity<User> userMessage = restTemplate.exchange("http://localhost:8083/User/getOne/" + id,
				HttpMethod.GET, null, User.class);
		return (User) userMessage.getBody();
	}

}
