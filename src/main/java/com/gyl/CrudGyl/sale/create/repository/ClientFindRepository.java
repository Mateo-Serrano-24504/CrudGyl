package com.gyl.CrudGyl.sale.create.repository;

import com.gyl.CrudGyl.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientFindRepository extends JpaRepository<Client, Long> {}
