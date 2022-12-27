package com.example.solva.model.dto;

import com.example.solva.model.enums.ExpenseCategory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static com.example.solva.constants.swagger.LimitSwaggerConstants.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = LIMIT_DTO_TITLE)
public class LimitCreateDto {
    @Schema(description = FIELD_LIMIT_COST_DESCRIPTION,example = FIELD_LIMIT_COST_EXAMPLE)
    private Double limitCost;
    @Schema(description = FIELD_LIMIT_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE)
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;
}
