package com.example.solva.service.impl;

import com.example.solva.model.LimitMoney;
import com.example.solva.model.dto.LimitCreateDto;
import com.example.solva.model.dto.LimitUpdateDto;
import com.example.solva.repository.LimitRepository;
import com.example.solva.service.LimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LimitServiceImpl implements LimitService {

    private final LimitRepository limitRepository;


    @Override
    public LimitMoney createLimit(LimitCreateDto limitCreateDto) {
        LimitMoney limitMoney=LimitMoney.builder()
                .limitCost(limitCreateDto.getLimitCost())
                .remainderLimit(limitCreateDto.getLimitCost())
                .limitExceeded(false)
                .limitCurrencyShortName("USD")
                .expenseCategory(limitCreateDto.getExpenseCategory())
                .build();

        return limitRepository.save(limitMoney);
    }

    @Override
    public LimitMoney updateLimit(LimitUpdateDto limitUpdateDto) {
        LimitMoney limitMoney=limitRepository.findById(limitUpdateDto.getId()).orElse(null);
        limitMoney.setRemainderLimit(limitUpdateDto.getLimitCost());
        limitMoney.setLimitCost(limitUpdateDto.getLimitCost());
        return limitRepository.save(limitMoney);
    }


}
