package com.gyl.SalesMicroservice.sale.create.provider.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.provider.Provider;
import com.gyl.SalesMicroservice.result.Result;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateClientFetchResponseDto;
import com.gyl.SalesMicroservice.sale.create.exception.SaleCreateClientFetchError;
import com.gyl.SalesMicroservice.sale.create.exception.SaleCreateClientFetchUnhandleableError;
import com.gyl.SalesMicroservice.sale.create.provider.SaleCreateClientFetchProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SaleCreateClientFetchProviderImpl
        extends Provider<SaleCreateClientFetchResponseDto, Long, SaleCreateClientFetchUnhandleableError>
        implements SaleCreateClientFetchProvider {
    private final RestClient restClient;

    public SaleCreateClientFetchProviderImpl(ObjectMapper objectMapper, RestClient restClient) {
        super(objectMapper);
        this.restClient = restClient;
    }

    @Override
    protected Result<ErrorFormat, SaleCreateClientFetchResponseDto> tryProvide(Long clientId) {
        ResponseEntity<SaleCreateClientFetchResponseDto> response = this.restClient
                .get()
                .uri("http://client-service:8080/clients/{id}", clientId)
                .retrieve()
                .toEntity(SaleCreateClientFetchResponseDto.class);
        return Result.ok(response.getBody(), response.getStatusCode().value());
    }

    @Override
    public SaleCreateClientFetchResponseDto fetch(Long clientId) {
        return super.provide(
                clientId,
                SaleCreateClientFetchUnhandleableError::new
        ).orElseThrow(SaleCreateClientFetchError::new);
    }
}
