package com.gyl.CrudGyl.product.create.service.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.create.dto.ProductCreateRequestDto;
import com.gyl.CrudGyl.product.create.exception.ProductTypeDoesNotExist;
import com.gyl.CrudGyl.product.create.mapper.ProductCreateMapper;
import com.gyl.CrudGyl.product.create.repository.ProductCreateRepository;
import com.gyl.CrudGyl.product.create.repository.ProductTypeFindRepository;
import com.gyl.CrudGyl.product.create.service.ProductCreateService;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.productType.entity.ProductType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class ProductCreateServiceImpl implements ProductCreateService {
    private final ProductCreateRepository repository;
    private final ProductTypeFindRepository productTypeFindRepository;
    private final ProductCreateMapper mapper;

    public ProductCreateServiceImpl(
            ProductCreateRepository repository,
            ProductTypeFindRepository productTypeFindRepository,
            ProductCreateMapper mapper
    ) {
        this.repository = repository;
        this.productTypeFindRepository = productTypeFindRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductCreateResponseDto create(ProductCreateRequestDto dto) {
        Instant now = Instant.now();
        Optional<ProductType> productType = this.productTypeFindRepository.findById(dto.productTypeId());
        if (productType.isEmpty()) {
            throw new ProductTypeDoesNotExist(dto.productTypeId());
        }
        Product product = this.mapper.fromDto(dto);
        product.setProductType(productType.get());
        product.setValidSince(now);
        product.setState(EntityState.ACTIVE);
        product.setCreatedAt(now);
        return this.mapper.toDto(this.repository.save(product));
    }
}
