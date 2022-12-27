package com.example.solva.model.dto;

import com.example.solva.model.enums.SortDirection;
import lombok.*;

@Getter
@Setter
public class SortRequestDto {
    private String key;
    private SortDirection direction;
}
