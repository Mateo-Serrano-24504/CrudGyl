package com.gyl.SalesMicroservice.saleDetail.update.provider;

import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleUpdateProductFetchResponseDto;

public interface SaleDetailUpdateProductFetchProvider {
    SaleUpdateProductFetchResponseDto fetch(Long productId);
}
