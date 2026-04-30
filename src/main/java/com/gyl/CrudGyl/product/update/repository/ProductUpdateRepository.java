package com.gyl.CrudGyl.product.update.repository;

import com.gyl.CrudGyl.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUpdateRepository extends JpaRepository<Product, Long> {}
