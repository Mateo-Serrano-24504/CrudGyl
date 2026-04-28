package com.gyl.CrudGyl.product.read.service.impl;

import com.gyl.CrudGyl.product.read.dto.ProductReadResponseDto;
import com.gyl.CrudGyl.product.read.exception.ProductDoesNotExist;
import com.gyl.CrudGyl.product.read.mapper.ProductReadMapper;
import com.gyl.CrudGyl.product.read.repository.ProductReadRepository;
import com.gyl.CrudGyl.product.read.service.ProductReadService;
import org.springframework.stereotype.Service;

@Service
public class ProductReadServiceImpl implements ProductReadService {
    private final ProductReadRepository repository;
    private final ProductReadMapper mapper;
    public ProductReadServiceImpl(ProductReadRepository repository, ProductReadMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductReadResponseDto read(Long id) {
        return this.repository
                .findById(id)
                .map(this.mapper::toDto)
                .orElseThrow(() -> new ProductDoesNotExist(id));
    }
}
