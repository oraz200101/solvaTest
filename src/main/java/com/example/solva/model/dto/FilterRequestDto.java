package com.example.solva.model.dto;


import com.example.solva.model.enums.FieldType;
import com.example.solva.model.enums.Operator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import static com.example.solva.constants.swagger.SearchCriteriaDto.*;

@Getter
@Setter
public class FilterRequestDto implements Serializable {
    @Schema(description = FIELD_KEY_FOR_SEARCH_DESCRIPTION,example = FIELD_VALUE_EXAMPLE )
    private String key;
    @Schema(description = FIELD_OPERATION_DESCRIPTION,example = FIELD_OPERATION_EXAMPLE)
    private Operator operator;
    @Schema(description = FIELD_TYPE_DESCRIPTION,example = FIELD_TYPE_EXAMPLE)
    private FieldType fieldType;
    @Schema(description = FIELD_VALUE_NAME_DESCRIPTION,example = FIELD_VALUE_NAME_EXAMPLE)
    private transient Object value;
    private transient Object valueTo;
    private transient List<Object> values;

}
