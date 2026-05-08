package com.gyl.SalesMicroservice.sale.create.repository;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleCreateRepository extends JpaRepository<Sale, Long> {}
