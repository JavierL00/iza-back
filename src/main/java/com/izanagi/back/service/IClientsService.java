package com.izanagi.back.service;

import com.izanagi.back.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientsService extends JpaRepository<Clients, Long> {
    Clients findByUsername(String username);
}
