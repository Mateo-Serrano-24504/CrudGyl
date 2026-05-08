package com.gyl.SalesMicroservice.saleDetail.readPage.service;

import com.gyl.SalesMicroservice.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import org.springframework.data.domain.Page;

public interface SaleDetailReadPageService {
    Page<SaleDetailReadPageResponseDto> readPage(Integer page, Integer size, Long saleId);
}
