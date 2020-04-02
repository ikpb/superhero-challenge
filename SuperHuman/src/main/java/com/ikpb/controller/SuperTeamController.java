package com.ikpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ikpb.domain.SuperHuman;
import com.ikpb.domain.SuperTeam;
import com.ikpb.service.SuperTeamService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class SuperTeamController {
	
	private SuperTeamService superTS;
	
	@Autowired
	public void setSuperTeamService(SuperTeamService superTS) {
		this.superTS = superTS;
	}

	@GetMapping("/super-team")
	@ResponseBody
	public List<SuperTeam> getAllSuperTeams(){
		return superTS.getAllSuperTeams();
	}
	@GetMapping("/super-team/{team_name}")
	@ResponseBody
	public SuperTeam getSuperHumanByName(@PathVariable String team_name){
		SuperTeam superT = superTS.getSuperTeamByName(team_name);
		return superT;
	}
	
	@PostMapping(path = "/super-team", consumes = "application/json")
	public ResponseEntity<?> addSuperTeam(@RequestBody SuperTeam superTeam){

		try {
			superTS.saveSuperTeam(superTeam);
			ResponseEntity.status(HttpStatus.CREATED);
			return ResponseEntity.ok().body("SuperTeam Created");
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping(path = "/super-team/{super_team}/super-human", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> updateSuperHumanByName(@PathVariable String super_team,@RequestBody SuperHuman superHuman){
		SuperTeam superT = superTS.getSuperTeamByName(super_team);
		superHuman.setTeam(superT);
		return ResponseEntity.ok().body("SuperHuman Updated");
	}
	
	@DeleteMapping(path="/super-team", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> deleteSuperHumanByName(@RequestBody String superTeam){
	superTS.deleteSuperTeam(superTeam);; 
	return ResponseEntity.ok().body("SuperTeam Deleted");
}
	
}
