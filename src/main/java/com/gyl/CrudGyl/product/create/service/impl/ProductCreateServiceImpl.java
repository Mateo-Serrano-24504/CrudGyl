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
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class ProductCreateServiceImpl implements ProductCreateService {
    private final ProductCreateRepository repository;
    private final ProductTypeReadRepository productTypeReadRepository;
    private final ProductCreateMapper mapper;

    public ProductCreateServiceImpl(
            ProductCreateRepository repository,
            ProductTypeReadRepository productTypeReadRepository,
            ProductCreateMapper mapper
    ) {
        this.repository = repository;
        this.productTypeReadRepository = productTypeReadRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductCreateResponseDto create(ProductCreateRequestDto dto) {
        Instant now = Instant.now();
        Optional<ProductType> productType = this.productTypeReadRepository.findById(dto.productTypeId());
        if (productType.isEmpty()) {
            throw new ProductCreateProductTypeDoesNotExist(dto.productTypeId());
        }
        Product product = this.mapper.fromDto(dto);
        product.setProductType(productType.get());
        product.setValidSince(now);
        product.setState(EntityState.ACTIVE);
        product.setCreatedAt(now);
        return this.mapper.toDto(this.repository.save(product));
    }
}
