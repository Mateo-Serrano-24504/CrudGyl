package com.gyl.CrudGyl.sale.update.service;

import com.gyl.CrudGyl.sale.update.dto.SaleUpdateRequestDto;
import com.gyl.CrudGyl.sale.update.dto.SaleUpdateResponseDto;

public interface SaleUpdateService {
    SaleUpdateResponseDto update(Long id, SaleUpdateRequestDto dto);
}
