package com.gyl.CrudGyl.saleDetail.create.service.impl;

import com.gyl.CrudGyl.saleDetail.create.dto.SaleDetailCreateRequestDto;
import com.gyl.CrudGyl.saleDetail.create.dto.SaleDetailCreateResponseDto;
import com.gyl.CrudGyl.saleDetail.create.mapper.SaleDetailCreateMapper;
import com.gyl.CrudGyl.saleDetail.create.repository.SaleDetailCreateRepository;
import com.gyl.CrudGyl.saleDetail.create.service.SaleDetailCreateService;
import org.springframework.stereotype.Service;

@Service
public class SaleDetailCreateServiceImpl implements SaleDetailCreateService {
    private final SaleDetailCreateRepository repository;
    private final SaleDetailCreateMapper mapper;
    public SaleDetailCreateServiceImpl(SaleDetailCreateRepository repository, SaleDetailCreateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SaleDetailCreateResponseDto create(SaleDetailCreateRequestDto dto) {
        return this.mapper.toDto(
                this.repository.save(
                        this.mapper.fromDto(dto)
                )
        );
    }
}
