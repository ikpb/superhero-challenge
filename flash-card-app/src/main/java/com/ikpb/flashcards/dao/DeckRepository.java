package com.ikpb.flashcards.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ikpb.flashcards.models.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck,String>{

}
