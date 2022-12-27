package com.example.solva.model.dto;

import com.example.solva.model.enums.SortDirection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static com.example.solva.constants.swagger.SearchCriteriaDto.*;

@Getter
@Setter
public class SortRequestDto {
    @Schema(description = FIELD_KEY_FOR_SORT_DESCRIPTION,example = FIELD_VALUE_FOR_SORT_EXAMPLE)
    private String key;
    @Schema(description = FIELD_DIRECTION_FOR_SORT_DESCRIPTION,example = FIELD_DIRECTION_FOR_SORT_EXAMPLE)
    private SortDirection direction;
}
