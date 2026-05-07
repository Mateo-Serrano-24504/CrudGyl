package com.gyl.ProductsMicroservice.product.update.repository;

import com.gyl.ProductsMicroservice.product.entity.HistoricProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricProductCreateRepository extends JpaRepository<HistoricProduct, Long> {}
