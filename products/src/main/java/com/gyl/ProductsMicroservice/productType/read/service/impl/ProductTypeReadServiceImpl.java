package com.gyl.ProductsMicroservice.productType.read.service.impl;

import com.gyl.ProductsMicroservice.productType.read.dto.ProductTypeReadResponseDto;
import com.gyl.ProductsMicroservice.productType.read.exception.ProductTypeReadProductTypeDoesNotExist;
import com.gyl.ProductsMicroservice.productType.read.mapper.ProductTypeReadMapper;
import com.gyl.ProductsMicroservice.productType.read.repository.ProductTypeReadRepository;
import com.gyl.ProductsMicroservice.productType.read.service.ProductTypeReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductTypeReadServiceImpl implements ProductTypeReadService {
    private final ProductTypeReadRepository repository;
    private final ProductTypeReadMapper mapper;

    @Override
    public ProductTypeReadResponseDto read(Long id) {
        return this.repository
                .findById(id)
                .map(this.mapper::toDto)
                .orElseThrow(() -> new ProductTypeReadProductTypeDoesNotExist(id));
    }
}
