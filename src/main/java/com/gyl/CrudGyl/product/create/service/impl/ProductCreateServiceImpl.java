package com.gyl.CrudGyl.product.create.service.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.exception.ProductCreateProductTypeDoesNotExist;
import com.gyl.CrudGyl.product.create.mapper.ProductCreateMapper;
import com.gyl.CrudGyl.product.create.repository.ProductCreateRepository;
import com.gyl.CrudGyl.product.create.service.ProductCreateService;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.read.repository.ProductTypeReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductCreateServiceImpl implements ProductCreateService {
    private final ProductCreateRepository repository;
    private final ProductTypeReadRepository productTypeReadRepository;
    private final ProductCreateMapper mapper;

    @Override
    public ProductCreateResponseDto create(ProductCreateRequestDto dto) {
        Instant now = Instant.now();
        ProductType productType = this.productTypeReadRepository
                .findById(dto.productTypeId())
                .orElseThrow(() -> new ProductCreateProductTypeDoesNotExist(dto.productTypeId()));
        Product product = this.mapper.fromDto(dto, EntityState.ACTIVE, productType, now);
        return this.mapper.toDto(this.repository.save(product));
    }
}
