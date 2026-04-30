package com.gyl.CrudGyl.productType.update.repository;

import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeUpdateRepository extends JpaRepository<ProductType, Long> {}
