package com.gyl.SalesMicroservice.sale.create.provider;

import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateProductFetchResponseDto;

public interface SaleCreateProductFetchProvider {
    SaleCreateProductFetchResponseDto fetch(Long productId);
}
