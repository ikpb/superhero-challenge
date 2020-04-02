package com.ikpb.service;

import java.util.List;

import com.ikpb.domain.SuperTeam;

public interface SuperTeamService {

	public List<SuperTeam> getAllSuperTeams();
	public SuperTeam getSuperTeamByName(String name);
	public void updateSuperTeam(SuperTeam team);
	public void deleteSuperTeam(String name);
	public void saveSuperTeam(SuperTeam superTeam);
}
