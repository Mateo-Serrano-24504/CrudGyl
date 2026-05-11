package com.gyl.SalesMicroservice.sale.readPage.controller;

import com.gyl.SalesMicroservice.sale.readPage.dto.SaleReadPageResponseDto;
import com.gyl.SalesMicroservice.sale.readPage.service.SaleReadPageService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SaleReadPageController {
    private final SaleReadPageService service;
    public SaleReadPageController(SaleReadPageService service) {
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
}
