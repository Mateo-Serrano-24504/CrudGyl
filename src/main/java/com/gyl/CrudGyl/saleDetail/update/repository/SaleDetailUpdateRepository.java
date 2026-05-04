package com.gyl.CrudGyl.saleDetail.update.repository;

import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailUpdateRepository extends JpaRepository<SaleDetail, Long> {}
