package com.loga.customerservice.repository;

import com.loga.customerservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByName(String name);

    Client findByContact(String contact);
}
