package com.gyl.SalesMicroservice.saleDetail.readPage.service.impl;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import com.gyl.SalesMicroservice.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import com.gyl.SalesMicroservice.saleDetail.readPage.mapper.SaleDetailReadPageMapper;
import com.gyl.SalesMicroservice.saleDetail.readPage.repository.SaleDetailReadPageRepository;
import com.gyl.SalesMicroservice.saleDetail.readPage.service.SaleDetailReadPageService;
import com.gyl.SalesMicroservice.saleDetail.readPage.spec.SaleDetailReadPageSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SaleDetailReadPageServiceImpl implements SaleDetailReadPageService {
    private final SaleDetailReadPageRepository repository;
    private final SaleDetailReadPageMapper mapper;
    public SaleDetailReadPageServiceImpl(
            SaleDetailReadPageRepository repository,
            SaleDetailReadPageMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<SaleDetailReadPageResponseDto> readPage(Integer page, Integer size, Long saleId) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<SaleDetail> spec = Specification
                .where(SaleDetailReadPageSpecification.hasSaleId(saleId))
                .and(SaleDetailReadPageSpecification.hasState(EntityState.ACTIVE));
        Page<SaleDetail> saleDetails = this.repository.findAll(spec, pageable);
        return saleDetails.map(this.mapper::toPageDto);
    }
}
