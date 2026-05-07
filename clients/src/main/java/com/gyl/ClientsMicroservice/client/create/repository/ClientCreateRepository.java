package com.gyl.ClientsMicroservice.client.create.repository;

import com.gyl.ClientsMicroservice.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCreateRepository extends JpaRepository<Client, Long> {}
