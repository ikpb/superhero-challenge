package com.ikpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping(path = "/super-human", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> addSuperHuman(@RequestBody SuperHuman superHuman){

		try {
			System.out.println(superHuman);
			superHS.saveSuperHuman(superHuman);
			ResponseEntity.status(HttpStatus.CREATED);
			return ResponseEntity.ok().body("SuperHuman Created");
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/super-human")
	@ResponseBody
	public ResponseEntity<?> updateSuperHumanByName(@RequestBody SuperHuman superHuman){
		superHS.updateSuperHuman(superHuman); 
		return ResponseEntity.ok().body("SuperHuman Updated");
	}
	@DeleteMapping("/super-human")
	@ResponseBody
	public ResponseEntity<?> deleteSuperHumanByName(@RequestBody SuperHuman superHuman){
	superHS.deleteSuperHuman(superHuman.getSuperHumanName());; 
	return ResponseEntity.ok().body("SuperHuman Deleted");
}
}
