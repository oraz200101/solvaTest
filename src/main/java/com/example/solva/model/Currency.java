package com.example.solva.model;

import com.example.solva.model.base.BaseEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.example.solva.constants.swagger.CurrencySwaggerConstants.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("currency")
public class Currency  {
   @Id
   @GeneratedValue
   @Schema(description = FIELD_CURRENCY_ID_DESCRIPTION,example = FIELD_CURRENCY_ID_EXAMPLE)
   private String id;
   @Schema(description = FIELD_CURRENCY_SYMBOL_DESCRIPTION,example = FIELD_CURRENCY_SYMBOL_EXAMPLE)
   private String symbol;
   @Schema(description = FIELD_CURRENCY_RATE_DESCRIPTION,example =FIELD_CURRENCY_RATE_EXAMPLE )
   private double rate;
   @Schema(description = FIELD_CURRENCY_TIMESTAMP_DESCRIPTION,example = FIELD_CURRENCY_TIMESTAMP_EXAMPLE)
   private Long timestamp;



}
