package com.example.solva.service.impl;

import com.example.solva.model.Currency;
import com.example.solva.repository.CurrencyRepository;
import com.example.solva.service.CurrencyClient;
import com.example.solva.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyClient currencyClient;
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyClient currencyClient, CurrencyRepository currencyRepository) {
        this.currencyClient = currencyClient;
        this.currencyRepository = currencyRepository;
    }

    public Currency getCurrency(){
        return currencyClient.getCurrencyBySymbol();
    }



    @Override
    public Currency create() {
        return currencyRepository.save(currencyClient.getCurrencyBySymbol());

    }
    @Override
    public List<Currency>currencies(){
        return currencyRepository.findAll();
    }


    @Override
    public Currency update() {

        List<Currency>currencies= currencyRepository.findAll();
        if(currencies.size()==0){
           return create();
        }
        else{
            Currency newCurrency=getCurrency();
        Currency currency=currencies.get(0);
        currency.setRate(newCurrency.getRate());
        currency.setTimestamp(newCurrency.getTimestamp());
        currency.setSymbol(newCurrency.getSymbol());
        return currencyRepository.save(currency);
        }
    }
}
