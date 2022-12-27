package com.example.solva.controller;

import com.example.solva.model.Currency;
import com.example.solva.service.impl.CurrencyServiceImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.solva.constants.swagger.CurrencySwaggerConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/currency")
@Tag(name = NAME_OF_CURRENCY_SERVICE,description = DESCRIPTION_OF_CURRENCY_CONTROLLER)
public class GetCurrencyController {

private final CurrencyServiceImpl currencyService;

    @PutMapping
    @Schema(description = DESCRIPTION_FOR_UPDATING_CURRENCY)
    public Currency updateCurrency(){
        return currencyService.update();
    }



}
