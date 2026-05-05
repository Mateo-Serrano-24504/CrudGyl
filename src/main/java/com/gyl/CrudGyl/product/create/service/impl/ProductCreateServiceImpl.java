package com.gyl.CrudGyl.product.create.service.impl;

import com.gyl.CrudGyl.product.create.builder.ProductCreateProductBuilder;
import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.exception.ProductCreateProductTypeDoesNotExist;
import com.gyl.CrudGyl.product.create.mapper.ProductCreateMapper;
import com.gyl.CrudGyl.product.create.repository.ProductCreateRepository;
import com.gyl.CrudGyl.product.create.service.ProductCreateService;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.read.repository.ProductTypeReadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Transactional
public class ProductCreateServiceImpl implements ProductCreateService {
    private final ProductCreateRepository repository;
    private final ProductTypeReadRepository productTypeReadRepository;
    private final ProductCreateMapper mapper;
    private final ProductCreateProductBuilder builder;

    public ProductCreateServiceImpl(
            ProductCreateRepository repository,
            ProductTypeReadRepository productTypeReadRepository,
            ProductCreateMapper mapper,
            ProductCreateProductBuilder builder
    ) {
        this.repository = repository;
        this.productTypeReadRepository = productTypeReadRepository;
        this.mapper = mapper;
        this.builder = builder;
    }

    @Override
    public ProductCreateResponseDto create(ProductCreateRequestDto dto) {
        Instant now = Instant.now();
        ProductType productType = this.productTypeReadRepository
                .findById(dto.productTypeId())
                .orElseThrow(() -> new ProductCreateProductTypeDoesNotExist(dto.productTypeId()));
        Product product = this.builder.build(dto, productType, now);
        return this.mapper.toDto(this.repository.save(product));
    }
}
