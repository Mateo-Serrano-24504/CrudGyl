package com.gyl.CrudGyl.sale.read.service;

import com.gyl.CrudGyl.sale.read.dto.SaleReadResponseDto;

public interface SaleReadService {
    SaleReadResponseDto read(Long id);
}
