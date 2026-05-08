package com.gyl.SalesMicroservice.sale.read.service.impl;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.read.exception.SaleCreateSaleDoesNotExist;
import com.gyl.SalesMicroservice.sale.read.dto.SaleReadResponseDto;
import com.gyl.SalesMicroservice.sale.read.mapper.SaleReadMapper;
import com.gyl.SalesMicroservice.sale.read.repository.SaleReadRepository;
import com.gyl.SalesMicroservice.sale.read.service.SaleReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SaleReadServiceImpl implements SaleReadService {
    private final SaleReadRepository repository;
    private final SaleReadMapper mapper;

    @Override
    public SaleReadResponseDto read(Long id) {
        Sale sale = this.repository
                .findById(id)
                .orElseThrow(() -> new SaleCreateSaleDoesNotExist(id));
        return this.mapper.toDto(sale);
    }
}
