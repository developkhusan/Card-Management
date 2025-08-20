package com.example.cardmanagement.repository;

import com.example.cardmanagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
