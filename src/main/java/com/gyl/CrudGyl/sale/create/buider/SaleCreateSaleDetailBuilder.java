package com.gyl.CrudGyl.sale.create.buider;

import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.sale.create.dto.SaleDetailCreateRequestDto;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;

import java.time.Instant;

public interface SaleCreateSaleDetailBuilder {
    SaleDetail build(SaleDetailCreateRequestDto dto, Product product, Instant time);
}
