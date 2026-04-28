package com.gyl.CrudGyl.sale.entity.create.repository;

import com.gyl.CrudGyl.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleCreateRepository extends JpaRepository<Sale, Long> {}
