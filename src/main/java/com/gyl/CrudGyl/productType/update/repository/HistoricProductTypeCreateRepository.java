package com.gyl.CrudGyl.productType.update.repository;

import com.gyl.CrudGyl.productType.entity.HistoricProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricProductTypeCreateRepository extends JpaRepository<HistoricProductType, Long> {}
