package com.gyl.CrudGyl.sale.readPage.service;

import com.gyl.CrudGyl.sale.readPage.dto.SaleReadPageResponseDto;
import org.springframework.data.domain.Page;

public interface SaleReadPageService {
    Page<SaleReadPageResponseDto> readPage(Integer page, Integer size, Long clientId);
}
