package com.gyl.CrudGyl.productType.create.service.impl;

import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateRequestDto;
import com.gyl.CrudGyl.productType.create.dto.ProductTypeCreateResponseDto;
import com.gyl.CrudGyl.productType.create.mapper.ProductTypeCreateMapper;
import com.gyl.CrudGyl.productType.create.repository.ProductTypeCreateRepository;
import com.gyl.CrudGyl.productType.create.service.ProductTypeCreateService;
import org.springframework.stereotype.Service;

@Service
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
    public ProductTypeCreateResponseDto create(ProductTypeCreateRequestDto dto) {
        return this.mapper.toDto(
                this.repository
                        .save(this.mapper.fromDto(dto))
        );
    }
}
