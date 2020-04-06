package com.ikpb.flashcards.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="deck")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deckname")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Deck {
	@Id
	@Column(name = "deckname")
	private String deckname;
	
	@OneToMany(mappedBy = "deck", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Card.class)
	private List<Card> card = new ArrayList<Card>();
	public String getDeckname() {
		return deckname;
	}
	public void setDeckName(String deckname) {
		this.deckname = deckname;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Deck [deckName=" + deckname + ", card=" + card + "]";
	}
	public Deck(String deckname, List<Card> card) {
		super();
		this.deckname = deckname;
		this.card = card;
	}
	public Deck() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
