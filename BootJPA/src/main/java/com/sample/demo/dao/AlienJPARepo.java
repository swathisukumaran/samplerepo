package com.sample.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.demo.model.Alien;



	public interface AlienJPARepo extends JpaRepository<Alien,Integer>{
		
	}
	
	
