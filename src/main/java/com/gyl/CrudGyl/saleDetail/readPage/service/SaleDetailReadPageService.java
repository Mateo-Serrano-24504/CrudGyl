package com.gyl.CrudGyl.saleDetail.readPage.service;

import com.gyl.CrudGyl.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import org.springframework.data.domain.Page;

public interface SaleDetailReadPageService {
    Page<SaleDetailReadPageResponseDto> readPage(Integer page, Integer size, Long saleId);
}
