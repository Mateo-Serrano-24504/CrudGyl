package com.gyl.SalesMicroservice.saleDetail.update.provider.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.provider.Provider;
import com.gyl.SalesMicroservice.result.Result;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleUpdateProductFetchResponseDto;
import com.gyl.SalesMicroservice.saleDetail.update.exception.SaleDetailUpdateProductFetchUnhandleableError;
import com.gyl.SalesMicroservice.saleDetail.update.exception.SaleDetailUpdateProductFetchError;
import com.gyl.SalesMicroservice.saleDetail.update.provider.SaleDetailUpdateProductFetchProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SaleDetailUpdateProductFetchProviderImpl
        extends Provider<SaleUpdateProductFetchResponseDto, Long, SaleDetailUpdateProductFetchUnhandleableError>
        implements SaleDetailUpdateProductFetchProvider {
    private final RestClient restClient;

    public SaleDetailUpdateProductFetchProviderImpl(ObjectMapper objectMapper, RestClient restClient) {
        super(objectMapper);
        this.restClient = restClient;
    }

    @Override
    protected Result<ErrorFormat, SaleUpdateProductFetchResponseDto> tryProvide(Long productId) {
        ResponseEntity<SaleUpdateProductFetchResponseDto> response = this.restClient
                .get()
                .uri("http://product-service:8080/products/{id}", productId)
                .retrieve()
                .toEntity(SaleUpdateProductFetchResponseDto.class);
        return Result.ok(response.getBody(), response.getStatusCode().value());
    }

    @Override
    public SaleUpdateProductFetchResponseDto fetch(Long productId) {
        return super.provide(
                productId,
                SaleDetailUpdateProductFetchUnhandleableError::new
        ).orElseThrow(SaleDetailUpdateProductFetchError::new);
    }
}
