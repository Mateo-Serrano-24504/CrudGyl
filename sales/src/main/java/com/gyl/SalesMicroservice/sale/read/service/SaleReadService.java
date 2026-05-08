package com.gyl.SalesMicroservice.sale.read.service;

import com.gyl.SalesMicroservice.sale.read.dto.SaleReadResponseDto;

public interface SaleReadService {
    SaleReadResponseDto read(Long id);
}
