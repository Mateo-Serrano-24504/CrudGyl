package com.gyl.CrudGyl.product.create.repository;

import com.gyl.CrudGyl.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCreateRepository extends JpaRepository<Product, Long> {}
