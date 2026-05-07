package com.gyl.CrudGyl.sale.create.buider.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.sale.create.buider.SaleCreateSaleBuilder;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Component
public class SaleCreateSaleBuilderImpl implements SaleCreateSaleBuilder {
    @Override
    public Sale build(List<SaleDetail> details, Client client, Instant time) {
        Sale sale = Sale.builder()
                .validSince(time)
                .state(EntityState.ACTIVE)
                .createdAt(time)
                .client(client)
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
