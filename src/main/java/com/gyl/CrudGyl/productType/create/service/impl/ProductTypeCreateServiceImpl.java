package com.gyl.CrudGyl.productType.create.service.impl;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.CrudGyl.productType.create.mapper.ProductTypeCreateMapper;
import com.gyl.CrudGyl.productType.create.repository.ProductTypeCreateRepository;
import com.gyl.CrudGyl.productType.create.service.ProductTypeCreateService;

public class ProductTypeCreateServiceImpl implements ProductTypeCreateService {
    private final ProductTypeCreateRepository repository;
    private final ProductTypeCreateMapper mapper;

    public ProductTypeCreateServiceImpl(
            ProductTypeCreateRepository repository,
            ProductTypeCreateMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductTypeCreateResponseDto create(ProductTypeCreateDto dto) {
        return this.mapper.toDto(
                this.repository
                        .save(this.mapper.fromDto(dto))
        );
    }
}
