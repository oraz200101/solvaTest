package com.example.solva.service.impl;

import com.example.solva.model.Transaction;
import com.example.solva.model.Currency;
import com.example.solva.model.LimitMoney;
import com.example.solva.model.dto.SearchRequestDto;
import com.example.solva.model.dto.TransactionCreateDto;
import com.example.solva.repository.TransactionRepository;
import com.example.solva.repository.LimitRepository;
import com.example.solva.service.TransactionService;
import com.example.solva.specification.SearchSpecification;
import com.example.solva.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service

public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final LimitRepository limitRepository;
    private final CurrencyServiceImpl currencyService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, LimitRepository limitRepository, CurrencyServiceImpl currencyService) {
        this.transactionRepository = transactionRepository;
        this.limitRepository = limitRepository;
        this.currencyService=currencyService;
    }

    @Override
    public Transaction createTransaction(TransactionCreateDto transactionCreateDto, Long limitId) throws ParseException {
        LimitMoney limitMoney=limitRepository.getById(limitId);

        if(!limitMoney.getExpenseCategory().equals(transactionCreateDto.getExpenseCategory())){
        return null;
    }
        Transaction transactionLimit = Transaction.builder()
                .accountFrom(transactionCreateDto.getAccountFrom())
                .accountTo(transactionCreateDto.getAccountTo())
                .expenseCategory(transactionCreateDto.getExpenseCategory())
                .limitMoney(returnNewLimit(limitMoney, transactionCreateDto.getSum()))
                .sum(transactionCreateDto.getSum())
                .currencyShortName("RUB")
                .build();


        return transactionRepository.save(transactionLimit);

}

    @Override
    public Page<Transaction> getAllTransactions(Pageable pageable,int pageNumber) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Page<Transaction> getTransactionsWithFilter(SearchRequestDto request, Pageable pageable, int pageNumber) {
        SearchSpecification<Transaction> specification=new SearchSpecification<>(request);
        return transactionRepository.findAll(specification,pageable.withPage(pageNumber));
    }

    private LimitMoney returnNewLimit(LimitMoney limitMoney,double sum) throws ParseException {
       LocalDateTime localDateTime=LocalDateTime.now();
       List<Currency>currencies=currencyService.currencies();
       Currency currency=currencies.get(0);
       Date dateNow= DateUtils.LocalDateToSimpleDateFormat(localDateTime);
       Date dateCurrency= DateUtils.TimestampToDate(currency.getTimestamp());
       if(DateUtils.dateEquals(dateNow,dateCurrency)!=0) {
           currencyService.update();
       }

           double newRemainder = limitMoney.getRemainderLimit() - (sum / currency.getRate());
           if (newRemainder < 0) {
               limitMoney.setLimitExceeded(true);
           }
           limitMoney.setRemainderLimit(newRemainder);

           return limitRepository.save(limitMoney);

    }
}

