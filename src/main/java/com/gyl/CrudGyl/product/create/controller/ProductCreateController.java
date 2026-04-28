package com.gyl.CrudGyl.product.create.controller;

import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.create.service.ProductCreateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products")
public class ProductCreateController {
    private final ProductCreateService service;
    public ProductCreateController(ProductCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreateResponseDto create(@Valid @RequestBody ProductCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
