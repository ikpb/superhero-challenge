package com.ikpb.dao;

import java.util.List;

import com.ikpb.domain.SuperTeam;

public interface SuperTeamDAO {

	public List<SuperTeam> getAllSuperTeams();
	public SuperTeam getSuperTeamByName(String name);
	public void updateSuperTeam(SuperTeam team);
	public void deleteSuperTeam(String name);
	public void saveSuperTeam(SuperTeam superTeam);
}
