package com.ikpb.flashcards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikpb.flashcards.dao.CardRepository;
import com.ikpb.flashcards.dao.DeckRepository;
import com.ikpb.flashcards.models.Card;
import com.ikpb.flashcards.models.Deck;


@Service
public class DeckServiceImpl implements DeckService {

	private DeckRepository deckRepository;
	
	private CardRepository cardRepository;
	
	@Autowired
	public void setDeckRepository(DeckRepository deckRepository) {
		this.deckRepository = deckRepository;
	}
	
	@Override
	public void insertDeck(Deck deck) {
		deckRepository.save(deck);

	}
	@Autowired
	public void setCardRepository(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	

	@Override
	public Deck getDeckByName(String deck) {
		// TODO Auto-generated method stub
		return deckRepository.getOne(deck);
	}

	@Override
	public List<Deck> getAllDecks() {
		
		return deckRepository.findAll();
	}

	@Override
	public Card updateDeck(String deck, Card card) {
		Deck deckT = deckRepository.getOne(deck);
		card.setDeck(deckT);
		cardRepository.save(card);
		return card;
	
	}

	@Override
	public void deleteDeck(String deck) {
		deckRepository.deleteById(deck);

	}

}
