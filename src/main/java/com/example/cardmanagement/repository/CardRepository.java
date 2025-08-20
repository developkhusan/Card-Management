package com.example.cardmanagement.repository;

import com.example.cardmanagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByNumber(String cardNumber);
    Optional<Card> findByPin(String pin);
}
