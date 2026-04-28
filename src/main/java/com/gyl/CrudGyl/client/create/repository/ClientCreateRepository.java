package com.gyl.CrudGyl.client.create.repository;

import com.gyl.CrudGyl.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCreateRepository extends JpaRepository<Client, Long> {}
