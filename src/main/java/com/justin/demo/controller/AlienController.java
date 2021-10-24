package com.justin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String getList() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("/{aid}")
	@ResponseBody
	public String get(@PathVariable int aid) {
		return repo.findById(aid).toString();
	}
	
}
