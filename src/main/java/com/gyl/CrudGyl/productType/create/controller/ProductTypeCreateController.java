package com.gyl.CrudGyl.productType.create.controller;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.CrudGyl.productType.create.service.ProductTypeCreateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products/types")
public class ProductTypeCreateController {
    private final ProductTypeCreateService service;
    public ProductTypeCreateController(ProductTypeCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductTypeCreateResponseDto create(@Valid @RequestBody ProductTypeCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
