package com.gyl.SalesMicroservice.saleDetail.update.service.impl;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateResponseDto;
import com.gyl.SalesMicroservice.saleDetail.update.exception.SaleDetailUpdateProductIdDoesNotMatch;
import com.gyl.SalesMicroservice.saleDetail.update.exception.SaleDetailUpdateSaleDetailDoesNotExist;
import com.gyl.SalesMicroservice.saleDetail.update.mapper.SaleDetailUpdateMapper;
import com.gyl.SalesMicroservice.saleDetail.update.provider.SaleDetailUpdateProductFetchProvider;
import com.gyl.SalesMicroservice.saleDetail.update.repository.SaleDetailUpdateRepository;
import com.gyl.SalesMicroservice.saleDetail.update.service.SaleDetailUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleDetailUpdateServiceImpl implements SaleDetailUpdateService {
    private final SaleDetailUpdateRepository repository;
    private final SaleDetailUpdateMapper mapper;
    private final SaleDetailUpdateProductFetchProvider productFetchService;

    private SaleDetail makeSaleDetail(SaleDetail original, SaleDetailUpdateRequestDto dto, Instant validationTime) {
        SaleDetail newSaleDetail = this.mapper.fromDto(dto);
        var product = this.productFetchService.fetch(dto.productId());
        if (!Objects.equals(dto.productId(), product.id())) {
            throw new SaleDetailUpdateProductIdDoesNotMatch(dto.productId(), product.id());
        }
        newSaleDetail.setId(original.getId());
        newSaleDetail.setCreatedAt(original.getCreatedAt());
        newSaleDetail.setValidSince(validationTime);
        newSaleDetail.setProductId(product.id());
        newSaleDetail.setUnitPrice(product.price());
        newSaleDetail.setSubtotal(product.price() * newSaleDetail.getAmount());
        newSaleDetail.setSale(original.getSale());
        return newSaleDetail;
    }

    @Override
    public SaleDetailUpdateResponseDto update(Long id, SaleDetailUpdateRequestDto dto) {
        Instant now = Instant.now();
        SaleDetail saleDetail = this.repository
                .findById(id)
                .orElseThrow(() -> new SaleDetailUpdateSaleDetailDoesNotExist(id));
        SaleDetail newSaleDetail = this.makeSaleDetail(saleDetail, dto, now);

        Sale sale = saleDetail.getSale();
        double newSubtotal = newSaleDetail.getState() == EntityState.ACTIVE ? newSaleDetail.getSubtotal() : 0d;
        sale.setTotal(sale.getTotal() - saleDetail.getSubtotal() + newSubtotal);
        sale.setValidSince(now);
        return this.mapper.toDto(this.repository.save(newSaleDetail));
    }
}
