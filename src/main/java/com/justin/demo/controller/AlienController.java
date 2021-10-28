package com.justin.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@PostMapping("")
	public Alien add(Alien alien) {
		repo.save(alien);
		return alien;
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
		System.out.println(repo.findByAidGreaterThanOrderByAidDesc(102));
		System.out.println(repo.findByTechSorted("Java"));
		
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Alien> getList() {
		return repo.findAll();
	}
	
	@RequestMapping("/{aid}")
	@ResponseBody
	public Optional<Alien> get(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}	
}
