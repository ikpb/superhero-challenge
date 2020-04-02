package com.ikpb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikpb.dao.SuperHumanDAO;
import com.ikpb.domain.SuperHuman;

@Service
public class SuperHumanServiceImpl implements SuperHumanService{

	private SuperHumanDAO superHDao;
	@Autowired
	public void setSuperHumanDao(SuperHumanDAO superHDao) {
		this.superHDao = superHDao;
	}
	
	@Override
	public List<SuperHuman> getAllSuperHumans() {
	
		return superHDao.getAllSuperHumans();
	}

	@Override
	public SuperHuman getSuperHumanByName(String name) {
		
		return superHDao.getSuperHumanByName(name);
	}

	@Override
	public void updateSuperHuman(SuperHuman superHuman) {
		superHDao.updateSuperHuman(superHuman);

	}

	@Override
	public void deleteSuperHuman(int id) {
		superHDao.deleteSuperHuman(id);

	}

	@Override
	public void saveSuperHuman(SuperHuman superHuman) {
		superHDao.saveSuperHuman(superHuman);

	}

}
