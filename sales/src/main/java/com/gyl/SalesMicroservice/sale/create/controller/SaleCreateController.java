package com.gyl.SalesMicroservice.sale.create.controller;

import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateRequestDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateResponseDto;
import com.gyl.SalesMicroservice.sale.create.service.SaleCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleCreateController {
    private final SaleCreateService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleCreateResponseDto create(@Valid @RequestBody SaleCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
