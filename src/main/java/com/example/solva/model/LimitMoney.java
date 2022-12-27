package com.example.solva.model;

import com.example.solva.model.base.BaseEntity;
import com.example.solva.model.enums.ExpenseCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.solva.constants.swagger.LimitSwaggerConstants.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class LimitMoney extends BaseEntity{
    @Schema(description = FIELD_LIMIT_COST_DESCRIPTION,example = FIELD_LIMIT_COST_EXAMPLE)
    private double limitCost;
    @Schema(description = FIELD_LIMIT_EXPENSE_CATEGORY_DESCRIPTION,example = FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE)
    @Enumerated(EnumType.STRING)
    private ExpenseCategory expenseCategory;
    @Schema(description = FIELD_LIMIT_DATE_DESCRIPTION,example = FIELD_LIMIT_DATE_EXAMPLE)
    @CreationTimestamp
    private LocalDateTime dateTime;
    @Schema(description = FIELD_LIMIT_REMAINDER_DESCRIPTION,example = FIELD_LIMIT_REMAINDER_EXAMPLE)

    private Double remainderLimit;
    @Schema(description = FIELD_LIMIT_EXCEEDED_DESCRIPTION,example = FIELD_LIMIT_EXCEEDED_EXAMPLE)
    private boolean limitExceeded;
    @Schema(description = FIELD_LIMIT_CURRENCY_DESCRIPTION,example = FIELD_LIMIT_CURRENCY_EXAMPLE)
    private String limitCurrencyShortName;

    @JsonIgnore
    @OneToMany(mappedBy = "limitMoney")
    private List<Transaction> transactionLimit;
}
