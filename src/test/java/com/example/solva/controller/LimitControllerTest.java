package com.example.solva.controller;

import com.example.solva.model.LimitMoney;
import com.example.solva.model.dto.LimitCreateDto;
import com.example.solva.model.dto.LimitUpdateDto;
import com.example.solva.model.enums.ExpenseCategory;
import com.example.solva.service.LimitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LimitController.class)
public class LimitControllerTest {
    @Autowired
    private MockMvc mockMvc;


}
