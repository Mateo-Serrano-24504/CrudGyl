package com.gyl.CrudGyl.saleDetail.create.service;

import com.gyl.CrudGyl.saleDetail.create.dto.SaleDetailCreateRequestDto;
import com.gyl.CrudGyl.saleDetail.create.dto.SaleDetailCreateResponseDto;

public interface SaleDetailCreateService {
    SaleDetailCreateResponseDto create(SaleDetailCreateRequestDto dto);
}
