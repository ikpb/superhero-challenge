package com.ikpb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name = "super_team")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teamName")
public class SuperTeam {
	@Id
	@Column(name="team_name")
	private String teamName;
	@Column(name="alignment")
	private int alignment;
	

	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = SuperHuman.class)
	private List<SuperHuman> superHuman = new ArrayList<SuperHuman>();
	
	
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
	
	public int getAlignment() {
		return alignment;
	}
	public void setAlignment(int alignment) {
		this.alignment = alignment;
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
