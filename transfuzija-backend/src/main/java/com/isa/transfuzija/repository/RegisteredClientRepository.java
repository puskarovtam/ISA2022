package com.isa.transfuzija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.transfuzija.model.RegisteredClient;

@Repository
public interface RegisteredClientRepository extends JpaRepository<RegisteredClient, Long> {

}
