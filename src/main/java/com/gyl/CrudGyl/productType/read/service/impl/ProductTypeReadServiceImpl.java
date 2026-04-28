package com.gyl.CrudGyl.productType.read.service.impl;

import com.gyl.CrudGyl.productType.read.dto.ProductTypeReadResponseDto;
import com.gyl.CrudGyl.productType.read.exception.ProductTypeDoesNotExist;
import com.gyl.CrudGyl.productType.read.mapper.ProductTypeReadMapper;
import com.gyl.CrudGyl.productType.read.repository.ProductTypeReadRepository;
import com.gyl.CrudGyl.productType.read.service.ProductTypeReadService;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeReadServiceImpl implements ProductTypeReadService {
    private final ProductTypeReadRepository repository;
    private final ProductTypeReadMapper mapper;
    public ProductTypeReadServiceImpl(ProductTypeReadRepository repository, ProductTypeReadMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductTypeReadResponseDto read(Long id) {
        return this.repository
                .findById(id)
                .map(this.mapper::toDto)
                .orElseThrow(() -> new ProductTypeDoesNotExist(id));
    }
}
