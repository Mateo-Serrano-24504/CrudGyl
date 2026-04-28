package com.gyl.CrudGyl.productType.read.controller;

import com.gyl.CrudGyl.productType.read.dto.ProductTypeReadResponseDto;
import com.gyl.CrudGyl.productType.read.service.ProductTypeReadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/types/")
public class ProductTypeReadController {
    private final ProductTypeReadService service;
    public ProductTypeReadController(ProductTypeReadService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductTypeReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
