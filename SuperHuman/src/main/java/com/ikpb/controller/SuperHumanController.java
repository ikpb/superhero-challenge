package com.ikpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.ikpb.domain.SuperHuman;
import com.ikpb.service.SuperHumanService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class SuperHumanController {
	
	private SuperHumanService superHS;
	
	@Autowired
	public void setSuperHumanService(SuperHumanService superHS) {
		this.superHS = superHS;
	}
	
	
	
	@GetMapping("/super-human")
	@ResponseBody
	public List<SuperHuman> getAllSuperHumans(){
		return superHS.getAllSuperHumans();
	}
	@GetMapping("/super-human/{super_human_name}")
	@ResponseBody
	public SuperHuman getSuperHumanByName(@PathVariable String super_human_name){
		SuperHuman superH = superHS.getSuperHumanByName(super_human_name); 
		return superH;
	}
	
	@PostMapping(path = "/super-human", consumes = "application/json")
	public ResponseEntity<?> addSuperHuman(@RequestBody SuperHuman superHuman){

		try {
			superHS.saveSuperHuman(superHuman);
			ResponseEntity.status(HttpStatus.CREATED);
			return ResponseEntity.ok().body("SuperHuman Created");
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	

}
