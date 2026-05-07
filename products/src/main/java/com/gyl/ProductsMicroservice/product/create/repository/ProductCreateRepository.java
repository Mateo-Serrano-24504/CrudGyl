package com.gyl.ProductsMicroservice.product.create.repository;

import com.gyl.ProductsMicroservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCreateRepository extends JpaRepository<Product, Long> {}
