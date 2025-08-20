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

import java.util.Optional;

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

            Card card = new Card();

            Optional<Card> byCardNumber = cardRepository.findByNumber(cardRequestDTO.getNumber());
            if (byCardNumber.isEmpty()){


                card.setNumber(cardRequestDTO.getNumber());
                card.setActive(true);
                card.setExpiration(cardRequestDTO.getExpiration());
                card.setCvc(cardRequestDTO.getCvc());
                card.setBalance(cardRequestDTO.getBalance());
                card.setPin(cardRequestDTO.getPin());
                cardRepository.save(card);

                return ResponseMessage.builder().status(true).message("Card created successfully").data(cardRequestDTO).build();


            }

            return ResponseMessage.builder().message("Card number already exists").status(false).data(card).build();


    }

    @Override
    public ResponseMessage updateCard( String last_pin, String new_pin, Double balance, Boolean active) {
        if(last_pin==null||new_pin==null||balance==null||active==null){
            return ResponseMessage.builder().status(false).message("All parameters are required").data(null).build();
        }

        Optional<Card> currentCard = cardRepository.findByPin(last_pin);

        if(currentCard.isEmpty()){
            return ResponseMessage.builder().status(false).message("Card not found").data(null).build();
        }
        Card card = currentCard.get();
        card.setBalance(balance);
        card.setActive(active);
        card.setPin(new_pin);
        cardRepository.save(card);


        return  ResponseMessage.builder().status(true).message("Card updated successfully").data(card).build();

    }

    @Override
    public ResponseMessage deleteCard(String card_number) {
        return null;
    }
}
