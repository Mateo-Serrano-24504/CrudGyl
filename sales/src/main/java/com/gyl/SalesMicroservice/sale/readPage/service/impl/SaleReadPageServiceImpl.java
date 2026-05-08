package com.gyl.SalesMicroservice.sale.readPage.service.impl;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.readPage.dto.SaleReadPageResponseDto;
import com.gyl.SalesMicroservice.sale.readPage.mapper.SaleReadPageMapper;
import com.gyl.SalesMicroservice.sale.readPage.repository.SaleReadPageRepository;
import com.gyl.SalesMicroservice.sale.readPage.spec.SaleReadSaleSpecification;
import com.gyl.SalesMicroservice.sale.readPage.service.SaleReadPageService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SaleReadPageServiceImpl implements SaleReadPageService {
    private final SaleReadPageRepository repository;
    private final SaleReadPageMapper mapper;
    public SaleReadPageServiceImpl(
            SaleReadPageRepository repository,
            SaleReadPageMapper mapper
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
}
