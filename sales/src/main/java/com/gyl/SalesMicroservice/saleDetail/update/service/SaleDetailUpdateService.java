package com.gyl.SalesMicroservice.saleDetail.update.service;

import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateResponseDto;

public interface SaleDetailUpdateService {
    SaleDetailUpdateResponseDto update(Long id, SaleDetailUpdateRequestDto dto);
}
