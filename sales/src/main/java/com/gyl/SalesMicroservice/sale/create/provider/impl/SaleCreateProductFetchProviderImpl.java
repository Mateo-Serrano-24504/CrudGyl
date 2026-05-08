package com.gyl.SalesMicroservice.sale.create.provider.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.provider.Provider;
import com.gyl.SalesMicroservice.result.Result;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateProductFetchResponseDto;
import com.gyl.SalesMicroservice.sale.create.exception.SaleCreateProductFetchError;
import com.gyl.SalesMicroservice.sale.create.exception.SaleCreateProductFetchUnhandleableError;
import com.gyl.SalesMicroservice.sale.create.provider.SaleCreateProductFetchProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SaleCreateProductFetchProviderImpl
        extends Provider<SaleCreateProductFetchResponseDto, Long, SaleCreateProductFetchUnhandleableError>
        implements SaleCreateProductFetchProvider {
    private final RestClient restClient;
    private final String productsServiceUri;

    public SaleCreateProductFetchProviderImpl(
            ObjectMapper objectMapper,
            RestClient restClient,
            @Value("${PRODUCTS_SERVICE_URI:http://products-service:8080}") String productsServiceUri
    ) {
        super(objectMapper);
        this.restClient = restClient;
        this.productsServiceUri = productsServiceUri;
    }

    @Override
    protected Result<ErrorFormat, SaleCreateProductFetchResponseDto> tryProvide(Long productId) {
        ResponseEntity<SaleCreateProductFetchResponseDto> response = this.restClient
                .get()
                .uri(this.productsServiceUri + "/products/{id}", productId)
                .retrieve()
                .toEntity(SaleCreateProductFetchResponseDto.class);
        return Result.ok(response.getBody(), response.getStatusCode().value());
    }

    @Override
    public SaleCreateProductFetchResponseDto fetch(Long productId) {
        return super.provide(
                productId,
                SaleCreateProductFetchUnhandleableError::new
        ).orElseThrow(SaleCreateProductFetchError::new);
    }
}
