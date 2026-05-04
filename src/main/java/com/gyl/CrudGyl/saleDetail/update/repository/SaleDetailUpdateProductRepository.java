package com.gyl.CrudGyl.saleDetail.update.repository;

import com.gyl.CrudGyl.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailUpdateProductRepository extends JpaRepository<Product, Long> {}
