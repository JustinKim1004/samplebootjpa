package com.justin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.demo.dao.AlienRepo;
import com.justin.demo.model.Alien;

@Controller
@RequestMapping("/alien")
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("")
	public String home() {
		return "/home.jsp";
	}

	@RequestMapping("/add")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "/home.jsp";
	}
	
	@RequestMapping("/get")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("show.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGraterThan(102));
		System.out.println(repo.findByTechSorted("Java"));
		
		mv.addObject(alien);
		return mv;
	}
}
