package com.example.solva.service;


import com.example.solva.model.Currency;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;

@FeignClient(value = "currencyclient",url ="https://api.twelvedata.com"
)
public interface CurrencyClient {
    @GetMapping("/exchange_rate?symbol=${twelve.data.symbol}&apikey=${twelve.data.api}")
    Currency getCurrencyBySymbol();
}
