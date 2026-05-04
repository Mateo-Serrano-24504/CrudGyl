package com.gyl.CrudGyl.saleDetail.readPage.spec;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import org.springframework.data.jpa.domain.Specification;

public class SaleDetailReadPageSpecification {
    public static Specification<SaleDetail> hasSaleId(Long saleId) {
        return (root, query, cb) ->
                saleId == null ? null : cb.equal(root.get("sale").get("id"), saleId);
    }

    public static Specification<SaleDetail> hasState(EntityState state) {
        return (root, query, cb) ->
                state == null ? null : cb.equal(root.get("state"), state);
    }
}
