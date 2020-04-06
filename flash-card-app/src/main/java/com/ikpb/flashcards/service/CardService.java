package com.ikpb.flashcards.service;

import java.util.List;

import com.ikpb.flashcards.models.Card;

public interface CardService {

	public void insertCard(Card card);
	
	public Card getCardByUUID(Long cardId);
	
	public List<Card> getAllCards();
	
	public void updateCard(String deck, Card card);
	
	public void deleteACard(Card card);
	
	public List<Card> getCardsByDeck(String deck);
}
