package com.gyl.CrudGyl.productType.update.service.impl;

import com.gyl.CrudGyl.productType.entity.HistoricProductType;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateResponseDto;
import com.gyl.CrudGyl.productType.update.exception.ProductTypeUpdateProductTypeDoesNotExist;
import com.gyl.CrudGyl.productType.update.mapper.ProductTypeUpdateMapper;
import com.gyl.CrudGyl.productType.update.repository.HistoricProductTypeCreateRepository;
import com.gyl.CrudGyl.productType.update.repository.ProductTypeUpdateRepository;
import com.gyl.CrudGyl.productType.update.service.ProductTypeUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class ProductTypeUpdateServiceImpl implements ProductTypeUpdateService {
    private final ProductTypeUpdateRepository repository;
    private final HistoricProductTypeCreateRepository historicProductTypeCreateRepository;
    private final ProductTypeUpdateMapper mapper;
    public ProductTypeUpdateServiceImpl(
            ProductTypeUpdateRepository repository,
            HistoricProductTypeCreateRepository historicProductTypeCreateRepository,
            ProductTypeUpdateMapper mapper
    ) {
        this.repository = repository;
        this.historicProductTypeCreateRepository = historicProductTypeCreateRepository;
        this.mapper = mapper;
    }

    private HistoricProductType createHistoricProductType(ProductType productType, Instant invalidationTime) {
        HistoricProductType historicProductType = new HistoricProductType(productType);
        historicProductType.setValidTo(invalidationTime);
        return historicProductType;
    }

    @Override
    public ProductTypeUpdateResponseDto update(Long id, ProductTypeUpdateRequestDto dto) {
        Instant now = Instant.now();
        Optional<ProductType> optionalProductType = this.repository.findById(id);
        if (optionalProductType.isEmpty()) {
            throw new ProductTypeUpdateProductTypeDoesNotExist(id);
        }
        ProductType productType = optionalProductType.get();
        this.historicProductTypeCreateRepository.save(this.createHistoricProductType(productType, now));
        ProductType newProductType = this.mapper.fromDto(dto);
        newProductType.setId(productType.getId());
        newProductType.setValidSince(now);
        newProductType.setCreatedAt(productType.getCreatedAt());
        return this.mapper.toDto(this.repository.save(newProductType));
    }
}
