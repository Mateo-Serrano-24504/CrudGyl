package com.gyl.CrudGyl.sale.entity.create.controller;

import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateResponseDto;
import com.gyl.CrudGyl.sale.entity.create.service.SaleCreateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleCreateController {
    private final SaleCreateService service;
    public SaleCreateController(SaleCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleCreateResponseDto create(@Valid @RequestBody SaleCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
