package com.cognizant.wms.portfolio.repository;

import com.cognizant.wms.portfolio.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    ClientEntity findByEmail(String email);
}
