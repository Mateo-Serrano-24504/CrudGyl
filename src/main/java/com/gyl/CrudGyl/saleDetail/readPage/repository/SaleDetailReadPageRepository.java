package com.gyl.CrudGyl.saleDetail.readPage.repository;

import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailReadPageRepository extends JpaRepository<SaleDetail, Long>, JpaSpecificationExecutor<SaleDetail> {}
