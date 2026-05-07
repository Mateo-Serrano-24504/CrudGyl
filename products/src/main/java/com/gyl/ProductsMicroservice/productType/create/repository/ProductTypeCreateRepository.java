package com.gyl.ProductsMicroservice.productType.create.repository;

import com.gyl.ProductsMicroservice.productType.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeCreateRepository extends JpaRepository<ProductType, Long> {}
