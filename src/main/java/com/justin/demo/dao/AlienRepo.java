package com.justin.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.justin.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThanOrderByAidDesc(int aid);
	
	@Query("FROM Alien WHERE tech=?1 ORDER BY aname")
	List<Alien> findByTechSorted(String tech);
	
	List<Alien> findByTechOrderByTechDesc(String tech);
}
