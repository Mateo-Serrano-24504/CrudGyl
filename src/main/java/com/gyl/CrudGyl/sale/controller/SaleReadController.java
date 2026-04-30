package com.gyl.CrudGyl.sale.controller;

import com.gyl.CrudGyl.sale.read.dto.SaleReadResponseDto;
import com.gyl.CrudGyl.sale.read.service.SaleReadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleReadController {
    private final SaleReadService service;
    public SaleReadController(SaleReadService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
