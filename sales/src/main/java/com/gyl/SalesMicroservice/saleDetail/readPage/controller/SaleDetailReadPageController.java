package com.gyl.SalesMicroservice.saleDetail.readPage.controller;

import com.gyl.SalesMicroservice.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import com.gyl.SalesMicroservice.saleDetail.readPage.service.SaleDetailReadPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales/details")
@RequiredArgsConstructor
public class SaleDetailReadPageController {
    private final SaleDetailReadPageService service;

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
