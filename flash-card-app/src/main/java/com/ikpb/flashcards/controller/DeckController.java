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
import com.ikpb.flashcards.models.Deck;
import com.ikpb.flashcards.service.DeckService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DeckController {
	
	private DeckService deckService;
	
	@Autowired
	public void setDeckService(DeckService deckService) {
		this.deckService = deckService;
	}
	
	@GetMapping(path = "/deck/{deckname}")
	public Deck getCar(@PathVariable String deckname) {
		Deck deck = deckService.getDeckByName(deckname);
		System.out.println(deck);
		return deck;
	}
	@GetMapping(path = "/deck")
	public List<Deck> getAllDecks() {
		return deckService.getAllDecks();
	}
	@PutMapping(path = "/deck/{deckname}/card")
	public Card updateDeck(@RequestBody Card card, @PathVariable String deckname) {
		return deckService.updateDeck(deckname, card);
	}
	
	@DeleteMapping(path = "/deck/{deckname}")
	public void deleteCar(@PathVariable String deckname) {
		deckService.deleteDeck(deckname);
	}

	@PostMapping(path = "/deck", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HttpStatus> addDeck(@RequestBody Deck deck) {
		deckService.insertDeck(deck);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

}
