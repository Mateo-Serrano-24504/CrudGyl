package com.gyl.CrudGyl.sale.update.repository;

import com.gyl.CrudGyl.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleUpdateRepository extends JpaRepository<Sale, Long> {}
