package com.gyl.SalesMicroservice.sale.update.service;

import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateRequestDto;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateResponseDto;

public interface SaleUpdateService {
    SaleUpdateResponseDto update(Long id, SaleUpdateRequestDto dto);
}
