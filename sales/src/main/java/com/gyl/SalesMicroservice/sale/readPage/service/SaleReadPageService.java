package com.gyl.SalesMicroservice.sale.readPage.service;

import com.gyl.SalesMicroservice.sale.readPage.dto.SaleReadPageResponseDto;
import org.springframework.data.domain.Page;

public interface SaleReadPageService {
    Page<SaleReadPageResponseDto> readPage(Integer page, Integer size, Long clientId);
}
