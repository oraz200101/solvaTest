package com.example.solva.model;

import com.example.solva.model.base.BaseEntity;
import com.example.solva.model.enums.ExpenseCategory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;


import java.time.LocalDateTime;

import static com.example.solva.constants.swagger.TransactionSwaggerConstants.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transaction extends BaseEntity {

    @Schema(description = FIELD_ACCOUNT_FROM_DESCRIPTION,example = FIELD_ACCOUNT_FROM_EXAMPLE)
    private Long accountFrom;

    @Schema(description = FIELD_ACCOUNT_TO_DESCRIPTION,example = FIELD_ACCOUNT_TO_EXAMPLE)
    private Long accountTo;
    @Schema(description = FIELD_CURRENCY_DESCRIPTION,example = FIELD_CURRENCY_EXAMPLE)
    private String currencyShortName;
    @Schema(description = FIELD_SUM_DESCRIPTION,example = FIELD_SUM_EXAMPLE)
    private Double sum;
    @Schema(description = FIELD_DATE_DESCRIPTION,example = FIELD_DATE_EXAMPLE)
    @CreationTimestamp
    private LocalDateTime dateTime;
    @Schema(description = FIELD_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_DATE_EXAMPLE)
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private LimitMoney limitMoney;



}
