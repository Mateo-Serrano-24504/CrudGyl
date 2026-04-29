package com.gyl.CrudGyl.saleDetail.create.repository;

import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailCreateRepository extends JpaRepository<SaleDetail, Long> {}
