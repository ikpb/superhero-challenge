package com.ikpb.flashcards.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="card")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cardid")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cardid")
	private  Long cardid;
	
	@Column(name="question")
	private String question;
	
	@Column(name="answer")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="deck")
	@JsonIdentityReference(alwaysAsId = true)
	private Deck deck;
	
	public Long getCardid() {
		return cardid;
	}
	public void setCardId(Long cardid) {
		this.cardid = cardid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public Card(Long cardid, String question, String answer, Deck deck) {
		super();
		this.cardid = cardid;
		this.question = question;
		this.answer = answer;
		this.deck = deck;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
