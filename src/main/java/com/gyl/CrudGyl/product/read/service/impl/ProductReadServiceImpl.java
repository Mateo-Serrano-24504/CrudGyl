package com.gyl.CrudGyl.product.read.service.impl;

import com.gyl.CrudGyl.product.read.dto.ProductReadResponseDto;
import com.gyl.CrudGyl.product.read.exception.ProductReadProductDoesNotExist;
import com.gyl.CrudGyl.product.read.mapper.ProductReadMapper;
import com.gyl.CrudGyl.product.read.repository.ProductReadRepository;
import com.gyl.CrudGyl.product.read.service.ProductReadService;
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
