package com.gyl.SalesMicroservice.sale.create.buider.impl;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.sale.create.buider.SaleCreateSaleBuilder;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Component
public class SaleCreateSaleBuilderImpl implements SaleCreateSaleBuilder {
    @Override
    public Sale build(List<SaleDetail> details, Long clientId, Instant time) {
        Sale sale = Sale.builder()
                .validSince(time)
                .state(EntityState.ACTIVE)
                .createdAt(time)
                .clientId(clientId)
                .salesDetails(details)
                .total(
                        details.stream()
                                .filter(detail -> Objects.equals(detail.getState(), EntityState.ACTIVE))
                                .mapToDouble(SaleDetail::getSubtotal)
                                .sum()
                ).build();
        details.forEach(detail -> detail.setSale(sale));
        return sale;
    }
}
