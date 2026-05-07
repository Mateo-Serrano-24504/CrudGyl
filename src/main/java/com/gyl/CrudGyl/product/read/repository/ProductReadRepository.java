package com.gyl.CrudGyl.product.read.repository;

import com.gyl.CrudGyl.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReadRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {}
