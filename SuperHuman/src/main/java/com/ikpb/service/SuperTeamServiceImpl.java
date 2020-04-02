package com.ikpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikpb.dao.SuperTeamDAO;
import com.ikpb.domain.SuperTeam;

@Service
public class SuperTeamServiceImpl implements SuperTeamService {
	private SuperTeamDAO superTDao;
	@Autowired
	public void setSuperHumanDao(SuperTeamDAO superTDao) {
		this.superTDao = superTDao;
	}
	
	@Override
	public List<SuperTeam> getAllSuperTeams() {
		
		return superTDao.getAllSuperTeams();
	}

	@Override
	public SuperTeam getSuperTeamByName(String name) {
		
		return superTDao.getSuperTeamByName(name);
	}

	@Override
	public void updateSuperTeam(SuperTeam team) {
		superTDao.updateSuperTeam(team);

	}

	@Override
	public void deleteSuperTeam(String name) {
		superTDao.deleteSuperTeam(name);

	}

	@Override
	public void saveSuperTeam(SuperTeam superTeam) {
		superTDao.saveSuperTeam(superTeam);

	}

}
