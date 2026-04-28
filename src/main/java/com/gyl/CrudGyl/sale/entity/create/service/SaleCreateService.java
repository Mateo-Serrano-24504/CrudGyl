package com.gyl.CrudGyl.sale.entity.create.service;

import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateResponseDto;

public interface SaleCreateService {
    SaleCreateResponseDto create(SaleCreateRequestDto dto);
}
