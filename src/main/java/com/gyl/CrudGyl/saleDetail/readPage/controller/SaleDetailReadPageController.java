package com.gyl.CrudGyl.saleDetail.readPage.controller;

import com.gyl.CrudGyl.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import com.gyl.CrudGyl.saleDetail.readPage.service.SaleDetailReadPageService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales/details")
public class SaleDetailReadPageController {
    private final SaleDetailReadPageService service;
    public SaleDetailReadPageController(SaleDetailReadPageService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<SaleDetailReadPageResponseDto> readPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam Long saleId
    ) {
        return this.service.readPage(page, size, saleId);
    }
}
