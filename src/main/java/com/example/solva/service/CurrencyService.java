package com.example.solva.service;

import com.example.solva.model.Currency;

import java.util.List;

public interface CurrencyService {
      Currency create();
      Currency update();
      List<Currency> currencies();

}
