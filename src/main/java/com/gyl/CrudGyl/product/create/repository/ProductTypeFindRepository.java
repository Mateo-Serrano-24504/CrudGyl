package com.gyl.CrudGyl.product.create.repository;

import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeFindRepository extends JpaRepository<ProductType, Long> {
}
