package com.gyl.SalesMicroservice.sale.read.repository;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleReadRepository extends JpaRepository<Sale, Long> {}
