package com.gyl.SalesMicroservice.sale.update.provider;

import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateClientFetchResponseDto;

public interface SaleUpdateClientFetchProvider {
    SaleUpdateClientFetchResponseDto fetch(Long clientId);
}
