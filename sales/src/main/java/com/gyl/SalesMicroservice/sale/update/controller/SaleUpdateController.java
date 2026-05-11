package com.gyl.SalesMicroservice.sale.update.controller;

import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateRequestDto;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateResponseDto;
import com.gyl.SalesMicroservice.sale.update.service.SaleUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SaleUpdateController {
    private final SaleUpdateService service;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleUpdateResponseDto update(@PathVariable Long id, @Valid @RequestBody SaleUpdateRequestDto dto) {
        return this.service.update(id, dto);
    }
}
