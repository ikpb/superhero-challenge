package com.ikpb.domain;

import java.util.List;

public class SuperTeam {
	private String teamName;
	private List<SuperHuman> superHuman;
	public SuperTeam(String teamName, List<SuperHuman> superHuman) {
		super();
		this.teamName = teamName;
		this.superHuman = superHuman;
	}
	public SuperTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<SuperHuman> getSuperHuman() {
		return superHuman;
	}
	public void setSuperHuman(List<SuperHuman> superHuman) {
		this.superHuman = superHuman;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((superHuman == null) ? 0 : superHuman.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperTeam other = (SuperTeam) obj;
		if (superHuman == null) {
			if (other.superHuman != null)
				return false;
		} else if (!superHuman.equals(other.superHuman))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperTeam teamName=" + teamName + ", superHuman=" + superHuman;
	}
	
	

}
