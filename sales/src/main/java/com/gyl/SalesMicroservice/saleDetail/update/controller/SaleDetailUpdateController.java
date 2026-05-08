package com.gyl.SalesMicroservice.saleDetail.update.controller;

import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateResponseDto;
import com.gyl.SalesMicroservice.saleDetail.update.service.SaleDetailUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales/details")
public class SaleDetailUpdateController {
    private final SaleDetailUpdateService service;
    public SaleDetailUpdateController(SaleDetailUpdateService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleDetailUpdateResponseDto update(@PathVariable Long id, @Valid @RequestBody SaleDetailUpdateRequestDto dto) {
        return this.service.update(id, dto);
    }
}
