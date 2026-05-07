package com.gyl.ClientsMicroservice.client.read.repository;

import com.gyl.ClientsMicroservice.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientReadRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {}
