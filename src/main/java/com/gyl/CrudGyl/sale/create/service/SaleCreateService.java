package com.gyl.CrudGyl.sale.create.service;

import com.gyl.CrudGyl.sale.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateResponseDto;

public interface SaleCreateService {
    SaleCreateResponseDto create(SaleCreateRequestDto dto);
}
