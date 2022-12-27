package com.example.solva.service;

import com.example.solva.model.LimitMoney;
import com.example.solva.model.dto.LimitCreateDto;
import com.example.solva.model.dto.LimitUpdateDto;
import org.springframework.http.ResponseEntity;

public interface LimitService {
    LimitMoney createLimit(LimitCreateDto limitCreateDto);
    LimitMoney updateLimit(LimitUpdateDto limitUpdateDto);

}
