package com.justin.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.justin.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

	/*
	List<Alien> findByTech(String tech);
	
	List<Alien> findByIdGreaterThanOrderByIdDesc(Integer id);
	*/
	
	@Query("FROM Alien WHERE tech=?1 ORDER BY aname")
	List<Alien> findByTechSorted(String tech);
	
	// List<Alien> findByTechOrderByTechDesc(String tech);
}
