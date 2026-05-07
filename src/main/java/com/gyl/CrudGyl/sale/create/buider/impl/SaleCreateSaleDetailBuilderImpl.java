package com.gyl.CrudGyl.sale.create.buider.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.sale.create.buider.SaleCreateSaleDetailBuilder;
import com.gyl.CrudGyl.sale.create.dto.SaleDetailCreateRequestDto;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class SaleCreateSaleDetailBuilderImpl implements SaleCreateSaleDetailBuilder {
    @Override
    public SaleDetail build(SaleDetailCreateRequestDto dto, Product product, Instant time) {
        return SaleDetail.builder()
                .validSince(time)
                .state(EntityState.ACTIVE)
                .createdAt(time)
                .product(product)
                .unitPrice(product.getPrice())
                .subtotal(product.getPrice() * dto.amount())
                .build();
    }
}
