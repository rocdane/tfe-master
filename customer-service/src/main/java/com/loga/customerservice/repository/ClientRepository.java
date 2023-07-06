package com.loga.customerservice.repository;

import com.loga.customerservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByName(String name);

    Client findByContact(String contact);
}
