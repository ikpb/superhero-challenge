package com.ikpb.flashcards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikpb.flashcards.models.Card;
import com.ikpb.flashcards.service.CardService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CardController {

	private CardService cardService;
	
	@Autowired
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	
	@GetMapping(path = "/card/{cardId}")
	public Card getCard(@PathVariable Long cardId) {
		Card card = cardService.getCardByUUID(cardId);
		System.out.println(card);
		return card;
	}
	@GetMapping(path = "/card")
	public List<Card> getAllCards() {
		return cardService.getAllCards();
	}
	@GetMapping(path = "/card/deck/{deckname}")
	public List<Card> getCardsByOwner(@PathVariable String deckname) {
		return cardService.getCardsByDeck(deckname);
	}
	@PutMapping(path = "/card/{deckname}")
	public void updateCard(@RequestBody Card card,@PathVariable String deckname) {
		cardService.updateCard(deckname,card);
	}
	
	@DeleteMapping(path = "/card")
	public ResponseEntity<?> deleteCard(@RequestBody Card card) {
		cardService.deleteACard(card);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(path = "/card", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> addCar(@RequestBody Card card) {
		cardService.insertCard(card);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
}
