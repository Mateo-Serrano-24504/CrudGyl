package com.gyl.SalesMicroservice.sale.update.service.impl;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateRequestDto;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateResponseDto;
import com.gyl.SalesMicroservice.sale.update.exception.SaleUpdateSaleDoesNotExist;
import com.gyl.SalesMicroservice.sale.update.mapper.SaleUpdateMapper;
import com.gyl.SalesMicroservice.sale.update.provider.SaleUpdateClientFetchProvider;
import com.gyl.SalesMicroservice.sale.update.repository.SaleUpdateRepository;
import com.gyl.SalesMicroservice.sale.update.service.SaleUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleUpdateServiceImpl implements SaleUpdateService {
    private final SaleUpdateRepository repository;
    private final SaleUpdateClientFetchProvider clientFetchProvider;
    private final SaleUpdateMapper mapper;

    @Override
    public SaleUpdateResponseDto update(Long id, SaleUpdateRequestDto dto) {
        Instant now = Instant.now();
        Sale sale = this.repository
                .findById(id)
                .orElseThrow(() -> new SaleUpdateSaleDoesNotExist(id));
        var client = this.clientFetchProvider.fetch(dto.clientId());
        sale.setValidSince(now);
        sale.setState(dto.state());
        sale.setClientId(client.id());
        return this.mapper.toDto(this.repository.save(sale));
    }
}
