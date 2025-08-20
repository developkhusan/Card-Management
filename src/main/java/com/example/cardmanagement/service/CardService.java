package com.example.cardmanagement.service;

import com.example.cardmanagement.dto.CardRequestDTO;
import com.example.cardmanagement.message.ResponseMessage;
public interface CardService {
    ResponseMessage getAllCards(Integer page, Integer size);

    ResponseMessage createCard(CardRequestDTO cardRequestDTO);

    ResponseMessage updateCard( String last_pin, String new_pin ,Double balance ,Boolean active);

    ResponseMessage deleteCard(String card_number);
}
