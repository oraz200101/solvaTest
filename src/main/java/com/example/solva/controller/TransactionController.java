package com.example.solva.controller;

import com.example.solva.model.Transaction;
import com.example.solva.model.dto.SearchRequestDto;
import com.example.solva.model.dto.TransactionCreateDto;
import com.example.solva.service.impl.TransactionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

import static com.example.solva.constants.swagger.TransactionSwaggerConstants.*;

@RestController
@RequestMapping("/v1/transaction")
@Tag(name = NAME_OF_TRANSACTION_CONTROLLER,description = DESCRIPTION_OF_TRANSACTION_CONTROLLER)
public class TransactionController {


    private final TransactionServiceImpl transactionService;
    @Autowired
    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/limit/{id}")
    @Operation(description = DESCRIPTION_OF_API_FOR_CREATING_TRANSACTION)
    public ResponseEntity<Transaction> create(@RequestBody @Validated TransactionCreateDto transactionCreateDto, @PathVariable Long id) throws ParseException {
        return   ResponseEntity.ok(transactionService.createTransaction(transactionCreateDto,id));

    }
    @GetMapping("/all/{pageNumber}")
    @Operation(description = DESCRIPTION_OF_API_FOR_GETTING_ALL_TRANSACTIONS)
    public Page<Transaction> findAll(@PageableDefault(size = 10)Pageable pageable, @PathVariable int pageNumber){
        return transactionService.getAllTransactions(pageable,pageNumber);
    }

    @PostMapping("/filter/{pageNumber}")
    @Operation(description = DESCRIPTION_OF_API_FOR_SEARCH_WITH_FILTER)
    public ResponseEntity<Page<Transaction>> searhcWithFilter(@RequestBody SearchRequestDto searchRequestDto, @PageableDefault(size = 10) Pageable pageable,
                                                              @PathVariable int pageNumber){
        return ResponseEntity.ok(transactionService.getTransactionsWithFilter(searchRequestDto,pageable,pageNumber));
    }

}
