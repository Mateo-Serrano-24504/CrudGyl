package com.gyl.SalesMicroservice.sale.create.service;

import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateRequestDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateResponseDto;

public interface SaleCreateService {
    SaleCreateResponseDto create(SaleCreateRequestDto dto);
}
