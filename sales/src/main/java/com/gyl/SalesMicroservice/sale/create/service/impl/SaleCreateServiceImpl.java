package com.gyl.SalesMicroservice.sale.create.service.impl;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.sale.create.buider.SaleCreateSaleBuilder;
import com.gyl.SalesMicroservice.sale.create.buider.SaleCreateSaleDetailBuilder;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateClientFetchResponseDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateProductFetchResponseDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateRequestDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateResponseDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleDetailCreateRequestDto;
import com.gyl.SalesMicroservice.sale.create.exception.SaleCreateClientIsInactive;
import com.gyl.SalesMicroservice.sale.create.exception.SaleCreateProductIsInactive;
import com.gyl.SalesMicroservice.sale.create.mapper.SaleCreateMapper;
import com.gyl.SalesMicroservice.sale.create.provider.SaleCreateClientFetchProvider;
import com.gyl.SalesMicroservice.sale.create.provider.SaleCreateProductFetchProvider;
import com.gyl.SalesMicroservice.sale.create.repository.SaleCreateRepository;
import com.gyl.SalesMicroservice.sale.create.service.SaleCreateService;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleCreateServiceImpl implements SaleCreateService {
    private final SaleCreateRepository repository;
    private final SaleCreateClientFetchProvider clientFetchProvider;
    private final SaleCreateProductFetchProvider productFetchProvider;
    private final SaleCreateMapper mapper;
    private final SaleCreateSaleBuilder builder;
    private final SaleCreateSaleDetailBuilder saleDetailBuilder;

    private SaleCreateClientFetchResponseDto getClient(Long id) {
        SaleCreateClientFetchResponseDto client = this.clientFetchProvider.fetch(id);
        if (client.state() != EntityState.ACTIVE) {
            throw new SaleCreateClientIsInactive(id);
        }
        return client;
    }

    private SaleCreateProductFetchResponseDto getProduct(Long id) {
        SaleCreateProductFetchResponseDto product = this.productFetchProvider.fetch(id);
        if (product.state() != EntityState.ACTIVE) {
            throw new SaleCreateProductIsInactive(id);
        }
        return product;
    }

    private SaleDetail buildSaleDetail(SaleDetailCreateRequestDto dto, Instant now) {
        SaleCreateProductFetchResponseDto product = this.getProduct(dto.productId());
        return this.saleDetailBuilder.build(dto, product, now);
    }

    @Override
    public SaleCreateResponseDto create(SaleCreateRequestDto dto) {
        Instant now = Instant.now();
        SaleCreateClientFetchResponseDto client = this.getClient(dto.clientId());
        List<SaleDetail> details = dto.details()
                        .stream()
                        .map(detail -> this.buildSaleDetail(detail, now))
                        .toList();
        Sale sale = this.builder.build(details, client.id(), now);
        return this.mapper.toDto(this.repository.save(sale));
    }
}
