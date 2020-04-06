package com.ikpb.flashcards.service;

import java.util.List;

import com.ikpb.flashcards.models.Card;
import com.ikpb.flashcards.models.Deck;

public interface DeckService {
	public void insertDeck(Deck deck);
	
	public Deck getDeckByName(String deck);
	
	public List<Deck> getAllDecks();
	
	public Card updateDeck(String deck, Card card);
	
	public void deleteDeck(String deck);
	
}
