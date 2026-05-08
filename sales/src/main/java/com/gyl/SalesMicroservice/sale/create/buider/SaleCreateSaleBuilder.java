package com.gyl.SalesMicroservice.sale.create.buider;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;

import java.time.Instant;
import java.util.List;

public interface SaleCreateSaleBuilder {
    Sale build(List<SaleDetail> details, Long clientId, Instant now);
}
