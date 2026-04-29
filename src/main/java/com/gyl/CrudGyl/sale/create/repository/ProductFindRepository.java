package com.gyl.CrudGyl.sale.create.repository;

import com.gyl.CrudGyl.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFindRepository extends JpaRepository<Product, Long> {}
