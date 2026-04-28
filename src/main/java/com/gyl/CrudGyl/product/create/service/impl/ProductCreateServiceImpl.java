package com.gyl.CrudGyl.product.create.service.impl;

import com.gyl.CrudGyl.product.create.dto.ProductCreateDto;
import com.gyl.CrudGyl.product.create.mapper.ProductCreateMapper;
import com.gyl.CrudGyl.product.create.repository.ProductCreateRepository;
import com.gyl.CrudGyl.product.create.service.ProductCreateService;
import com.gyl.CrudGyl.product.create.dto.ProductCreateResponseDto;

public class ProductCreateServiceImpl implements ProductCreateService {
    private final ProductCreateRepository repository;
    private final ProductCreateMapper mapper;

    public ProductCreateServiceImpl(
            ProductCreateRepository repository,
            ProductCreateMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductCreateResponseDto create(ProductCreateDto dto) {
        return this.mapper.toDto(
                this.repository
                        .save(this.mapper.fromDto(dto))
        );
    }
}
