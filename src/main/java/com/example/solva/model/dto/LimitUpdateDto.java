package com.example.solva.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.example.solva.constants.swagger.BaseEntitySwaggerConstants.FIELD_ID_DESCRIPTION;
import static com.example.solva.constants.swagger.BaseEntitySwaggerConstants.FIELD_ID_EXAMPLE;
import static com.example.solva.constants.swagger.LimitSwaggerConstants.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = LIMIT_UPDATE_TITLE)
public class LimitUpdateDto {
    @Schema( description = FIELD_ID_DESCRIPTION,example = FIELD_ID_EXAMPLE)
    private Long id;
    @Schema(description = FIELD_LIMIT_COST_DESCRIPTION,example = FIELD_LIMIT_COST_EXAMPLE)
    private Double limitCost;
}
