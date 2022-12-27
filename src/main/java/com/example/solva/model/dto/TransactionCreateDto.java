package com.example.solva.model.dto;

import com.example.solva.model.enums.ExpenseCategory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static com.example.solva.constants.swagger.TransactionSwaggerConstants.*;
import static com.example.solva.constants.validation.TransactionConstants.PATTERN_OF_ACCOUNT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = TRANSACTION_DTO)
public class TransactionCreateDto {
    @DecimalMin(value = "1000000000",message = PATTERN_OF_ACCOUNT)
    @DecimalMax(value = "9999999999",message = PATTERN_OF_ACCOUNT)
    @Schema(description = FIELD_ACCOUNT_FROM_DESCRIPTION,example = FIELD_ACCOUNT_FROM_EXAMPLE)
    private Long accountFrom;
    @DecimalMin(value = "1000000000",message = PATTERN_OF_ACCOUNT)
    @DecimalMax(value = "9999999999",message = PATTERN_OF_ACCOUNT)
    @Schema(description = FIELD_ACCOUNT_TO_DESCRIPTION,example = FIELD_ACCOUNT_TO_EXAMPLE)
    private Long accountTo;
    @Schema(description = FIELD_SUM_DESCRIPTION,example = FIELD_SUM_EXAMPLE)
    private Double sum;
    @Schema(description = FIELD_CURRENCY_DESCRIPTION,example = FIELD_CURRENCY_EXAMPLE)
    private String currencyShortName;
    @Schema(description = FIELD_DATE_DESCRIPTION,example = FIELD_DATE_EXAMPLE)
    @CreationTimestamp
    private LocalDateTime dateTime;
    @Schema(description = FIELD_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_EXPENSE_CATEGORY_EXAMPLE)
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;

}
