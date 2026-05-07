package com.gyl.ProductsMicroservice.productType.update.repository;

import com.gyl.ProductsMicroservice.productType.entity.HistoricProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricProductTypeCreateRepository extends JpaRepository<HistoricProductType, Long> {}
