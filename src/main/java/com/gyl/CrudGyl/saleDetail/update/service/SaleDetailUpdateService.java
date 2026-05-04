package com.gyl.CrudGyl.saleDetail.update.service;

import com.gyl.CrudGyl.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.CrudGyl.saleDetail.update.dto.SaleDetailUpdateResponseDto;

public interface SaleDetailUpdateService {
    SaleDetailUpdateResponseDto update(Long id, SaleDetailUpdateRequestDto dto);
}
