package com.example.solva.model.dto;


import com.example.solva.model.enums.FieldType;
import com.example.solva.model.enums.Operator;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FilterRequestDto implements Serializable {

    private String key;

    private Operator operator;

    private FieldType fieldType;
    private transient Object value;
    private transient Object valueTo;
    private transient List<Object> values;

}
