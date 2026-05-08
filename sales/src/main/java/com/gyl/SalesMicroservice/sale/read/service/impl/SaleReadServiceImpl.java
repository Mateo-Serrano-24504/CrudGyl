package com.gyl.SalesMicroservice.sale.read.service.impl;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.read.exception.SaleCreateSaleDoesNotExist;
import com.gyl.SalesMicroservice.sale.read.dto.SaleReadResponseDto;
import com.gyl.SalesMicroservice.sale.read.mapper.SaleReadMapper;
import com.gyl.SalesMicroservice.sale.read.repository.SaleReadRepository;
import com.gyl.SalesMicroservice.sale.read.service.SaleReadService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SaleReadServiceImpl implements SaleReadService {
    private final SaleReadRepository repository;
    private final SaleReadMapper mapper;
    public SaleReadServiceImpl(
            SaleReadRepository repository,
            SaleReadMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SaleReadResponseDto read(Long id) {
        Optional<Sale> sale = this.repository.findById(id);
        if (sale.isEmpty()) {
            throw new SaleCreateSaleDoesNotExist(id);
        }
        return this.mapper.toDto(sale.get());
    }
}
