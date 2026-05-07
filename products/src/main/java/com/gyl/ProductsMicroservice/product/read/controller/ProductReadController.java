package com.gyl.ProductsMicroservice.product.read.controller;

import com.gyl.ProductsMicroservice.product.read.dto.ProductReadResponseDto;
import com.gyl.ProductsMicroservice.product.read.service.ProductReadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductReadController {
    private final ProductReadService service;
    public ProductReadController(ProductReadService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
