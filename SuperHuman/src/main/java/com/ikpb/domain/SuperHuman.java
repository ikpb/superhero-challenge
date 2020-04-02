package com.ikpb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="superhumans")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "superHumanName")
public class SuperHuman {


@Id
@Column(name="super_name")
private String superHumanName;

@Column(name="alias")
private String alias;

@Column(name="superpower")
private String superPower;

@Column(name="weakness")
private String weakness;

@Column(name="alignementNumber")
private int alignmentNumber;


@ManyToOne
@JoinColumn(name="team")
@JsonIdentityReference(alwaysAsId = true)
private SuperTeam team;



public SuperTeam getTeam() {
	return team;
}
public void setTeam(SuperTeam team) {
	this.team = team;
}
public String getSuperHumanName() {
	return superHumanName;
}
public void setSuperHumanName(String superHumanName) {
	this.superHumanName = superHumanName;
}
public String getAlias() {
	return alias;
}
public void setAlias(String alias) {
	this.alias = alias;
}
public String getSuperPower() {
	return superPower;
}
public void setSuperPower(String superPower) {
	this.superPower = superPower;
}
public String getWeakness() {
	return weakness;
}
public void setWeakness(String weakness) {
	this.weakness = weakness;
}
public int getAlignmentNumber() {
	return alignmentNumber;
}
public void setAlignmentNumber(int alignmentNumber) {
	this.alignmentNumber = alignmentNumber;
}


public SuperHuman(String superHumanName, String alias, String superPower, String weakness, int alignmentNumber,
		SuperTeam team) {
	super();
	this.superHumanName = superHumanName;
	this.alias = alias;
	this.superPower = superPower;
	this.weakness = weakness;
	this.alignmentNumber = alignmentNumber;
	this.team = team;
}

public SuperHuman() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((alias == null) ? 0 : alias.hashCode());
	result = prime * result + alignmentNumber;
	result = prime * result + ((superHumanName == null) ? 0 : superHumanName.hashCode());
	result = prime * result + ((superPower == null) ? 0 : superPower.hashCode());
	result = prime * result + ((weakness == null) ? 0 : weakness.hashCode());
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
	SuperHuman other = (SuperHuman) obj;
	if (alias == null) {
		if (other.alias != null)
			return false;
	} else if (!alias.equals(other.alias))
		return false;
	if (alignmentNumber != other.alignmentNumber)
		return false;
	if (superHumanName == null) {
		if (other.superHumanName != null)
			return false;
	} else if (!superHumanName.equals(other.superHumanName))
		return false;
	if (superPower == null) {
		if (other.superPower != null)
			return false;
	} else if (!superPower.equals(other.superPower))
		return false;
	if (weakness == null) {
		if (other.weakness != null)
			return false;
	} else if (!weakness.equals(other.weakness))
		return false;
	return true;
}
@Override
public String toString() {
	return "superHumanName=" + superHumanName + ", alias=" + alias + ", superPower="
			+ superPower + ", weakness=" + weakness + ", alignmentNumber=" + alignmentNumber;
}

}
