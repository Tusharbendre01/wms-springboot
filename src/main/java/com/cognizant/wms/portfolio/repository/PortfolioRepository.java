package com.cognizant.wms.portfolio.repository;

import com.cognizant.wms.portfolio.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioEntity,Long> {
    List<PortfolioEntity> findByClient_ClientId(Long clientId);
}
