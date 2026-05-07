package com.gyl.CrudGyl.sale.create.buider;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;

import java.time.Instant;
import java.util.List;

public interface SaleCreateSaleBuilder {
    Sale build(List<SaleDetail> details, Client client, Instant now);
}
