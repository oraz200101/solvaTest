package com.example.solva.service;

import com.example.solva.model.Transaction;
import com.example.solva.model.dto.SearchRequestDto;
import com.example.solva.model.dto.TransactionCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface TransactionService {
    Transaction createTransaction(TransactionCreateDto transactionCreateDto, Long limitId)throws ParseException;
    Page<Transaction> getAllTransactions(Pageable pageable,int pageNumber);
    Page<Transaction>getTransactionsWithFilter(SearchRequestDto request, Pageable pageable, int pageNumber);
}
