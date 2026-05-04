package com.gyl.CrudGyl.sale.read.controller;

import com.gyl.CrudGyl.sale.read.dto.SaleReadPageResponseDto;
import com.gyl.CrudGyl.sale.read.dto.SaleReadResponseDto;
import com.gyl.CrudGyl.sale.read.service.SaleReadService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleReadController {
    private final SaleReadService service;
    public SaleReadController(SaleReadService service) {
        this.service = service;
    }

    @GetMapping
    public Page<SaleReadPageResponseDto> readPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long clientId
    ) {
        return this.service.readPage(page, size, clientId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
