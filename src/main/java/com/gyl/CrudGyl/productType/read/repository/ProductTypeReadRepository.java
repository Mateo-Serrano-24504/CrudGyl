package com.gyl.CrudGyl.productType.read.repository;

import com.gyl.CrudGyl.productType.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeReadRepository extends JpaRepository<ProductType, Long> {}
