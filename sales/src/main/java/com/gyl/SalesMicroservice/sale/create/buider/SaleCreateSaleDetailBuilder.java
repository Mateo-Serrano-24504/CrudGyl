package com.gyl.SalesMicroservice.sale.create.buider;

import com.gyl.SalesMicroservice.sale.create.dto.SaleDetailCreateRequestDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateProductFetchResponseDto;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;

import java.time.Instant;

public interface SaleCreateSaleDetailBuilder {
    SaleDetail build(SaleDetailCreateRequestDto dto, SaleCreateProductFetchResponseDto product, Instant time);
}
