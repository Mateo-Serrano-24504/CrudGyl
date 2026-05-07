package com.gyl.CrudGyl.productType.update.service.impl;

import com.gyl.CrudGyl.productType.entity.HistoricProductType;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.update.builder.ProductTypeUpdateProductTypeBuilder;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateResponseDto;
import com.gyl.CrudGyl.productType.update.exception.ProductTypeUpdateProductTypeDoesNotExist;
import com.gyl.CrudGyl.productType.update.mapper.ProductTypeUpdateHistoricProductTypeMapper;
import com.gyl.CrudGyl.productType.update.mapper.ProductTypeUpdateMapper;
import com.gyl.CrudGyl.productType.update.repository.HistoricProductTypeCreateRepository;
import com.gyl.CrudGyl.productType.update.repository.ProductTypeUpdateRepository;
import com.gyl.CrudGyl.productType.update.service.ProductTypeUpdateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductTypeUpdateServiceImpl implements ProductTypeUpdateService {
    private final ProductTypeUpdateRepository repository;
    private final HistoricProductTypeCreateRepository historicProductTypeCreateRepository;
    private final ProductTypeUpdateMapper mapper;
    private final ProductTypeUpdateHistoricProductTypeMapper historicProductTypeMapper;
    private final ProductTypeUpdateProductTypeBuilder builder;

    private HistoricProductType createHistoricProductType(ProductType productType, Instant invalidationTime) {
        return this.historicProductTypeMapper.toHistoric(productType, invalidationTime);
    }

    @Override
    public ProductTypeUpdateResponseDto update(Long id, ProductTypeUpdateRequestDto dto) {
        Instant now = Instant.now();
        ProductType productType = this.repository
                .findById(id)
                .orElseThrow(() -> new ProductTypeUpdateProductTypeDoesNotExist(id));
        this.historicProductTypeCreateRepository.save(this.createHistoricProductType(productType, now));
        ProductType newProductType = this.builder.build(productType, dto, now);
        return this.mapper.toDto(this.repository.save(newProductType));
    }
}
