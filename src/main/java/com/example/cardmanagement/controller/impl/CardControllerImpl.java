package com.example.cardmanagement.controller.impl;

import com.example.cardmanagement.controller.CardController;
import com.example.cardmanagement.dto.CardRequestDTO;
import com.example.cardmanagement.message.ResponseMessage;
import com.example.cardmanagement.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardControllerImpl implements CardController {
private final CardService cardService;
private ResponseMessage responseMessage;

    @Override
    public ResponseEntity<?> getAllCards(Integer page, Integer size) {
        ResponseMessage responseMessage = cardService.getAllCards(page, size);
        return ResponseEntity.status(responseMessage.getStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(responseMessage);
    }

    @Override
    public ResponseEntity<?> updateCard(String last_pin, String new_pin, Double balance, Boolean active) {
        ResponseMessage responseMessage = cardService.updateCard(last_pin, new_pin, balance, active);
        return ResponseEntity.status(responseMessage.getStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(responseMessage);
    }

    @Override
    public ResponseEntity<?> deleteCard(String card_number) {
        ResponseMessage responseMessage = cardService.deleteCard(card_number);
        return ResponseEntity.status(responseMessage.getStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(responseMessage);
    }

    @Override
    public ResponseEntity<?> createCard(CardRequestDTO cardRequestDTO) {
        ResponseMessage responseMessage = cardService.createCard(cardRequestDTO);
        return ResponseEntity.status(responseMessage.getStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(responseMessage);
    }
}

