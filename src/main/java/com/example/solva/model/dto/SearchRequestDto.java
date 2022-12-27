package com.example.solva.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
public class SearchRequestDto {

    private List<FilterRequestDto> filterRequestDtos;
    private List<SortRequestDto>sortRequestDtos;

    public List<FilterRequestDto> getFilters() {
        if(Objects.isNull(this.filterRequestDtos)) return new ArrayList<>();
        return this.filterRequestDtos;
    }

    public List<SortRequestDto> getSorts() {
        if (Objects.isNull(this.sortRequestDtos)) return new ArrayList<>();
        return this.sortRequestDtos;
    }
}
