package com.cognizant.wms.portfolio.service;

import com.cognizant.wms.portfolio.entity.PortfolioEntity;
import com.cognizant.wms.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    // Create or update portfolio
    public PortfolioEntity savePortfolio(PortfolioEntity portfolio) {
        portfolio.setLastUpdated(new Date());
        return portfolioRepository.save(portfolio);
    }

    // Get portfolio by ID
    public PortfolioEntity getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }

    // Get all portfolios for a client
    public List<PortfolioEntity> getPortfoliosByClientId(Long clientId) {
        return portfolioRepository.findByClient_ClientId(clientId);
    }

    // Get all portfolios
    public List<PortfolioEntity> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    // Rebalance Portfolio (Dummy Logic for Now)
    public PortfolioEntity rebalancePortfolio(Long id) {
        Optional<PortfolioEntity> optionalPortfolio = portfolioRepository.findById(id);
        if (optionalPortfolio.isPresent()) {
            PortfolioEntity portfolio = optionalPortfolio.get();

            // Dummy Rebalancing Logic (Adjust Allocation Summary)
            portfolio.setAllocationSummary("{ \"Stocks\": \"50%\", \"Bonds\": \"30%\", \"Cash\": \"20%\" }");
            portfolio.setLastUpdated(new Date());

            return portfolioRepository.save(portfolio);
        }
        return null;
    }
}
