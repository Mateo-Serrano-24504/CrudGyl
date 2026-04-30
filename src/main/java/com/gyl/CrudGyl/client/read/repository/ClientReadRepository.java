package com.gyl.CrudGyl.client.read.repository;

import com.gyl.CrudGyl.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientReadRepository extends JpaRepository<Client, Long> {}
