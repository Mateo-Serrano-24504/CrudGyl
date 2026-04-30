package com.gyl.CrudGyl.productType.update.controller;

import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateResponseDto;
import com.gyl.CrudGyl.productType.update.service.ProductTypeUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/types")
public class ProductTypeUpdateController {
    private final ProductTypeUpdateService service;
    public ProductTypeUpdateController(ProductTypeUpdateService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductTypeUpdateResponseDto update(@PathVariable Long id, @Valid @RequestBody ProductTypeUpdateRequestDto dto) {
        return this.service.update(id, dto);
    }
}
