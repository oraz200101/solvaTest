package com.example.solva.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.solva.constants.swagger.SearchCriteriaDto.SEARCH_CRITERIA_DTO_TITLE;

@Getter
@Setter
@Schema(title = SEARCH_CRITERIA_DTO_TITLE)
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
