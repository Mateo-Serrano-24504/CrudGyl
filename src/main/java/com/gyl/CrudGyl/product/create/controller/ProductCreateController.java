package com.gyl.CrudGyl.product.create.controller;

import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.create.service.ProductCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCreateController {
    private final ProductCreateService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreateResponseDto create(@Valid @RequestBody ProductCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
