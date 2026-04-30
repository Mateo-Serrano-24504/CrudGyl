package com.gyl.CrudGyl.product.update.repository;

import com.gyl.CrudGyl.product.entity.HistoricProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricProductCreateRepository extends JpaRepository<HistoricProduct, Long> {}
