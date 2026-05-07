package com.gyl.ClientsMicroservice.client.update.repository;

import com.gyl.ClientsMicroservice.client.entity.HistoricClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricClientCreateRepository extends JpaRepository<HistoricClient, Long> {}
