package com.gyl.ProductsMicroservice.product.update.controller;

import com.gyl.ProductsMicroservice.product.update.dto.ProductUpdateRequestDto;
import com.gyl.ProductsMicroservice.product.update.dto.ProductUpdateResponseDto;
import com.gyl.ProductsMicroservice.product.update.service.ProductUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductUpdateController {
    private final ProductUpdateService service;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductUpdateResponseDto update(@PathVariable Long id, @Valid @RequestBody ProductUpdateRequestDto dto) {
        return this.service.update(id, dto);
    }
}
