package com.ikpb.service;

import java.util.List;

import com.ikpb.domain.SuperHuman;

public interface SuperHumanService {
	public List<SuperHuman> getAllSuperHumans();
	public SuperHuman getSuperHumanByName(String name);
	public void updateSuperHuman(SuperHuman superHuman);
	public void deleteSuperHuman(String name);
	public void saveSuperHuman(SuperHuman superHuman);
}
