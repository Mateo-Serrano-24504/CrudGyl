package com.gyl.ProductsMicroservice.product.update.repository;

import com.gyl.ProductsMicroservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUpdateRepository extends JpaRepository<Product, Long> {}
