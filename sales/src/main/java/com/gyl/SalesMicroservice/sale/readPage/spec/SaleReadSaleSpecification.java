package com.gyl.SalesMicroservice.sale.readPage.spec;

import com.gyl.SalesMicroservice.persistence.EntityState;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import org.springframework.data.jpa.domain.Specification;

public class SaleReadSaleSpecification {
    public static Specification<Sale> hasClientId(Long clientId) {
        return (root, query, cb) ->
                clientId == null ? null : cb.equal(root.get("clientId"), clientId);
    }

    public static Specification<Sale> hasState(EntityState state) {
        return (root, query, cb) ->
                state == null ? null : cb.equal(root.get("state"), state);
    }
}
