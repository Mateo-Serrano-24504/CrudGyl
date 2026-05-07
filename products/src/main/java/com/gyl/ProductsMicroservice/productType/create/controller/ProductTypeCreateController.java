package com.gyl.ProductsMicroservice.productType.create.controller;

import com.gyl.ProductsMicroservice.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.ProductsMicroservice.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.ProductsMicroservice.productType.create.service.ProductTypeCreateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/types")
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
