package com.bae.pokeapi.service;

import org.springframework.stereotype.Service;

@Service
public interface SearchService {

	public Object findPokemon(String pokemon);

	public Object findType(String type);

	public Object findAbility(String ability);

}
