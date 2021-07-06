package com.sample.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sample.demo.dao.AlienJPARepo;
import com.sample.demo.dao.AlienRepo;
import com.sample.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@Autowired
	AlienJPARepo jpaRepo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien()) ;
		
		System.out.println(repo.findByTech("JAVA"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSorted("JAVA"));
		
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/getAllAlien")
	public ModelAndView getAllAlien() {
		ModelAndView mv = new ModelAndView("showAllAlien.jsp");
		List<Alien> alien = (List<Alien>) repo.findAll(); 
		
		System.out.println(repo.findAll());
		
		List<Alien> alienList = new ArrayList<>();
		
		for (Alien alien2 : alien) {
			alienList.add(alien2);
			System.out.println(alien2.getAid()+alien2.getAname()+"/n");
		}
	
		mv.addObject("alienList", alienList);
		return mv;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public String aliens() {
		
		return repo.findAll().toString();
		
	}
	
	@RequestMapping("/aliens/{aid}")
	@ResponseBody
	public String getAliensById(@PathVariable int  aid) {
		
		return repo.findById(aid).toString();
		
		
	}
	//JPARepo
	@RequestMapping(path = "/getAliens",produces = "application/xml")
	@ResponseBody
	public List<Alien> getAliens() {
		
		return jpaRepo.findAll();
		
	}
	
	@RequestMapping("/getAliensByAid/{aid}")
	@ResponseBody
	public Optional<Alien> getAliensByAid(@PathVariable int  aid) {
		
		return jpaRepo.findById(aid);
		
		
	}
	//using REST API
	@PostMapping(path = "/addAlien",consumes = "application/xml")
	public Alien addAlienByRESTAPI(@RequestBody Alien alien) {
		
		 repo.save(alien);
		 return alien;
		
	}
	
	@DeleteMapping(path = "/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a = jpaRepo.getOne(aid);
		jpaRepo.delete(a);
		return "Deleted !";
				
	}
	
	@PutMapping(path="/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		
		jpaRepo.save(alien);
		return alien;
		
	}
}
