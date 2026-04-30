package com.gyl.CrudGyl.client.update.repository;

import com.gyl.CrudGyl.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUpdateRepository extends JpaRepository<Client, Long> {}
