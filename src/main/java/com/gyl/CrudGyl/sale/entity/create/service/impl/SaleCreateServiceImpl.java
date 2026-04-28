package com.gyl.CrudGyl.sale.entity.create.service.impl;

import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateResponseDto;
import com.gyl.CrudGyl.sale.entity.create.mapper.SaleCreateMapper;
import com.gyl.CrudGyl.sale.entity.create.repository.SaleCreateRepository;
import com.gyl.CrudGyl.sale.entity.create.service.SaleCreateService;
import org.springframework.stereotype.Service;

@Service
public class SaleCreateServiceImpl implements SaleCreateService {
    private final SaleCreateRepository repository;
    private final SaleCreateMapper mapper;
    public SaleCreateServiceImpl(SaleCreateRepository repository, SaleCreateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SaleCreateResponseDto create(SaleCreateRequestDto dto) {
        return this.mapper.toDto(
                this.repository.save(this.mapper.fromDto(dto))
        );
    }
}
