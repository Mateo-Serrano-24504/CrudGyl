package com.gyl.ProductsMicroservice.product.read.service.impl;

import com.gyl.ProductsMicroservice.product.read.dto.ProductReadResponseDto;
import com.gyl.ProductsMicroservice.product.read.exception.ProductReadProductDoesNotExist;
import com.gyl.ProductsMicroservice.product.read.mapper.ProductReadMapper;
import com.gyl.ProductsMicroservice.product.read.repository.ProductReadRepository;
import com.gyl.ProductsMicroservice.product.read.service.ProductReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductReadServiceImpl implements ProductReadService {
    private final ProductReadRepository repository;
    private final ProductReadMapper mapper;

    @Override
    public ProductReadResponseDto read(Long id) {
        return this.repository
                .findById(id)
                .map(this.mapper::toDto)
                .orElseThrow(() -> new ProductReadProductDoesNotExist(id));
    }
}
