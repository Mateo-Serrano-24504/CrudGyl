package com.gyl.SalesMicroservice.sale.update.provider.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.provider.Provider;
import com.gyl.SalesMicroservice.result.Result;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateClientFetchResponseDto;
import com.gyl.SalesMicroservice.sale.update.exception.SaleUpdateClientFetchError;
import com.gyl.SalesMicroservice.sale.update.exception.SaleUpdateClientFetchUnhandleableError;
import com.gyl.SalesMicroservice.sale.update.provider.SaleUpdateClientFetchProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SaleUpdateClientFetchProviderImpl
        extends Provider<SaleUpdateClientFetchResponseDto, Long, SaleUpdateClientFetchUnhandleableError>
        implements SaleUpdateClientFetchProvider {
    private final RestClient restClient;

    public SaleUpdateClientFetchProviderImpl(ObjectMapper objectMapper, RestClient restClient) {
        super(objectMapper);
        this.restClient = restClient;
    }

    @Override
    protected Result<ErrorFormat, SaleUpdateClientFetchResponseDto> tryProvide(Long clientId) {
        ResponseEntity<SaleUpdateClientFetchResponseDto> response = this.restClient
                .get()
                .uri("http://client-service:8080/clients/{id}", clientId)
                .retrieve()
                .toEntity(SaleUpdateClientFetchResponseDto.class);
        return Result.ok(response.getBody(), response.getStatusCode().value());
    }

    @Override
    public SaleUpdateClientFetchResponseDto fetch(Long clientId) {
        return super.provide(
                clientId,
                SaleUpdateClientFetchUnhandleableError::new
        ).orElseThrow(SaleUpdateClientFetchError::new);
    }
}
