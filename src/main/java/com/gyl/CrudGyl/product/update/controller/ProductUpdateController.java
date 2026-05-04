package com.gyl.CrudGyl.product.update.controller;

import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateResponseDto;
import com.gyl.CrudGyl.product.update.service.ProductUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductUpdateController {
    private final ProductUpdateService service;
    public ProductUpdateController(ProductUpdateService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductUpdateResponseDto update(@PathVariable Long id, @Valid @RequestBody ProductUpdateRequestDto dto) {
        return this.service.update(id, dto);
    }
}
