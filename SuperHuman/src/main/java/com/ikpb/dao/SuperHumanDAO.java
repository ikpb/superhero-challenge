package com.ikpb.dao;

import java.util.List;

import com.ikpb.domain.SuperHuman;

public interface SuperHumanDAO {
	
	public List<SuperHuman> getAllSuperHumans();
	public SuperHuman getSuperHumanByName(String name);
	public SuperHuman getSuperHumanById(int id);
	public void updateSuperHuman(SuperHuman superHuman);
	public void deleteSuperHuman(int id);
	public void saveSuperHuman(SuperHuman superHuman);

}
