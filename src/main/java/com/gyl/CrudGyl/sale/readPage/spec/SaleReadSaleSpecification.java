package com.gyl.CrudGyl.sale.readPage.spec;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.sale.entity.Sale;
import org.springframework.data.jpa.domain.Specification;

public class SaleReadSaleSpecification {
    public static Specification<Sale> hasClientId(Long clientId) {
        return (root, query, cb) ->
                clientId == null ? null : cb.equal(root.get("client").get("id"), clientId);
    }

    public static Specification<Sale> hasState(EntityState state) {
        return (root, query, cb) ->
                state == null ? null : cb.equal(root.get("state"), state);
    }
}
