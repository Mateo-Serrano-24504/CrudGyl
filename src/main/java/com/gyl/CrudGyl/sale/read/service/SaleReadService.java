package com.gyl.CrudGyl.sale.read.service;

import com.gyl.CrudGyl.sale.read.dto.SaleReadPageResponseDto;
import com.gyl.CrudGyl.sale.read.dto.SaleReadResponseDto;
import org.springframework.data.domain.Page;

public interface SaleReadService {
    Page<SaleReadPageResponseDto> readPage(Integer page, Integer size, Long clientId);
    SaleReadResponseDto read(Long id);
}
