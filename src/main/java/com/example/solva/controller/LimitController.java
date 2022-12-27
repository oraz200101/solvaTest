package com.example.solva.controller;

import com.example.solva.exception.domain.BodyObjectIdDoesNotMatchRequestIdCustomException;
import com.example.solva.model.LimitMoney;
import com.example.solva.model.dto.LimitCreateDto;
import com.example.solva.model.dto.LimitUpdateDto;
import com.example.solva.service.impl.LimitServiceImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.solva.constants.swagger.LimitSwaggerConstants.*;

@RestController
@RequestMapping("/v1/limit")
@RequiredArgsConstructor
@Tag(name = NAME_OF_LIMIT_SERVICE,description = DESCRIPTION_OF_LIMIT_CONTROLLER)
public class LimitController {

    private final LimitServiceImpl limitService;
    @PostMapping
    @Schema(description = DESCRIPTION_OF_FOR_CREATING_LIMIT)
    public ResponseEntity<LimitMoney>create(@RequestBody LimitCreateDto limitCreateDto){
        return ResponseEntity.ok(limitService.createLimit(limitCreateDto));
    }
    @PutMapping("/{id}")
    @Schema(description = DESCRIPTION_OF_FOR_UPDATE_LIMIT)
    public ResponseEntity<LimitMoney>update(@PathVariable Long id, LimitUpdateDto limitUpdateDto){
        if(!limitUpdateDto.getId().equals(id))
            throw new BodyObjectIdDoesNotMatchRequestIdCustomException();
        return ResponseEntity.ok(limitService.updateLimit(limitUpdateDto));
    }





}
