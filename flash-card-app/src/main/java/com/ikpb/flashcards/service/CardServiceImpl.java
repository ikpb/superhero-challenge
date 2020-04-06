package com.ikpb.flashcards.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikpb.flashcards.dao.CardRepository;
import com.ikpb.flashcards.dao.DeckRepository;
import com.ikpb.flashcards.models.Card;
import com.ikpb.flashcards.models.Deck;

@Service
public class CardServiceImpl implements CardService {
	private CardRepository cardRepository;
	
	private DeckRepository deckRepository;

	@Autowired
	public void setCardRepository(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@Autowired
	public void setDeckRepository(DeckRepository deckRepository) {
		this.deckRepository = deckRepository;
	}
	
	@Override
	public void insertCard(Card card) {
		cardRepository.save(card);

	}

	@Override
	public Card getCardByUUID(Long cardId) {
		
		return cardRepository.getOne(cardId);
	}

	@Override
	public List<Card> getAllCards() {
		
		return cardRepository.findAll();
	}

	@Override
	public void updateCard(String deck, Card card) {
		Deck deckT = deckRepository.getOne(deck);
		card.setDeck(deckT);
		cardRepository.save(card);

	}

	@Override
	public void deleteACard(Card card) {
		
		cardRepository.delete(card);

	}

	@Override
	public List<Card> getCardsByDeck(String deck) {
		return deckRepository.getOne(deck).getCard();
	}

}
