package com.ikpb.flashcards.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikpb.flashcards.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long>{
	
	


}
