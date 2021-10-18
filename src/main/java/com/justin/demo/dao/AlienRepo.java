package com.justin.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.justin.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
	
}
