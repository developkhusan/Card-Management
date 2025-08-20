package com.example.cardmanagement.service.impl;

import com.example.cardmanagement.dto.CardRequestDTO;
import com.example.cardmanagement.entity.Card;
import com.example.cardmanagement.message.ResponseMessage;
import com.example.cardmanagement.repository.CardRepository;
import com.example.cardmanagement.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    @Override
    public ResponseMessage getAllCards(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Card> all = cardRepository
                .findAll(pageRequest);
        if (all.isEmpty()){
            return ResponseMessage.builder().status(false).message("Cards no such exists").data(null).build();
        }
        return ResponseMessage
                .builder()
                .message("Cards fetched successfully")
                .status(true)
                .data(all)
                .build();
    }

    @Override
    public ResponseMessage createCard(CardRequestDTO cardRequestDTO) {
        return null;
    }

    @Override
    public ResponseMessage updateCard(String card_number, String last_pin, String new_pin, Double balance, Boolean active) {
        return null;
    }

    @Override
    public ResponseMessage deleteCard(String card_number) {
        return null;
    }
}
