package com.gyl.SalesMicroservice.sale.update.repository;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleUpdateRepository extends JpaRepository<Sale, Long> {}
