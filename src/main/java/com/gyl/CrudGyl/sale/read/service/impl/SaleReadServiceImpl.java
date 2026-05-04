package com.gyl.CrudGyl.sale.read.service.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.read.dto.SaleReadPageResponseDto;
import com.gyl.CrudGyl.sale.read.exception.SaleCreateSaleDoesNotExist;
import com.gyl.CrudGyl.sale.read.dto.SaleReadResponseDto;
import com.gyl.CrudGyl.sale.read.mapper.SaleReadMapper;
import com.gyl.CrudGyl.sale.read.repository.SaleReadRepository;
import com.gyl.CrudGyl.sale.read.service.SaleReadService;
import com.gyl.CrudGyl.sale.read.spec.SaleReadSaleSpecification;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<SaleReadPageResponseDto> readPage(Integer page, Integer size, Long clientId) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Sale> spec = Specification
                .where(SaleReadSaleSpecification.hasClientId(clientId))
                .and(SaleReadSaleSpecification.hasState(EntityState.ACTIVE));
        Page<Sale> sales = repository.findAll(spec, pageable);

        return sales.map(this.mapper::toPageDto);
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
