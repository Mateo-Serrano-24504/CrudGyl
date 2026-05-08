package com.gyl.SalesMicroservice.sale.create.provider;

import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateClientFetchResponseDto;

public interface SaleCreateClientFetchProvider {
    SaleCreateClientFetchResponseDto fetch(Long clientId);
}
