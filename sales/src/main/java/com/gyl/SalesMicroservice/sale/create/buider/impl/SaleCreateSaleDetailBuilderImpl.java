package com.gyl.SalesMicroservice.sale.create.buider.impl;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.sale.create.buider.SaleCreateSaleDetailBuilder;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateProductFetchResponseDto;
import com.gyl.SalesMicroservice.sale.create.dto.SaleDetailCreateRequestDto;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SaleCreateSaleDetailBuilderImpl implements SaleCreateSaleDetailBuilder {
    @Override
    public SaleDetail build(SaleDetailCreateRequestDto dto, SaleCreateProductFetchResponseDto product, Instant time) {
        return SaleDetail.builder()
                .amount(dto.amount())
                .validSince(time)
                .state(EntityState.ACTIVE)
                .createdAt(time)
                .productId(product.id())
                .unitPrice(product.price())
                .subtotal(product.price() * dto.amount())
                .build();
    }
}
