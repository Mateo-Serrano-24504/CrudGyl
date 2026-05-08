package com.gyl.SalesMicroservice.sale.read.controller;

import com.gyl.SalesMicroservice.sale.read.dto.SaleReadResponseDto;
import com.gyl.SalesMicroservice.sale.read.service.SaleReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleReadController {
    private final SaleReadService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
