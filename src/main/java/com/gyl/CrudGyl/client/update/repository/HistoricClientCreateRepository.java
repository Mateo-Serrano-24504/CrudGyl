package com.gyl.CrudGyl.client.update.repository;

import com.gyl.CrudGyl.client.entity.HistoricClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricClientCreateRepository extends JpaRepository<HistoricClient, Long> {}
