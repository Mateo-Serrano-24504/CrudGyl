package com.gyl.CrudGyl.sale.readPage.repository;

import com.gyl.CrudGyl.sale.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleReadPageRepository extends JpaRepository<Sale, Long>, JpaSpecificationExecutor<Sale> {}
