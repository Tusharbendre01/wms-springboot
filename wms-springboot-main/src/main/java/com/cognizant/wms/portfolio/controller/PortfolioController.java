package com.cognizant.wms.portfolio.controller;

import com.cognizant.wms.portfolio.entity.PortfolioEntity;
import com.cognizant.wms.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // Create or update a portfolio
    @PostMapping("/save")
    public PortfolioEntity savePortfolio(@RequestBody PortfolioEntity portfolio) {
        return portfolioService.savePortfolio(portfolio);
    }

    // Get a portfolio by ID
    @GetMapping("/{id}")
    public PortfolioEntity getPortfolioById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id);
    }

    // Get all portfolios for a specific client
    @GetMapping("/client/{clientId}")
    public List<PortfolioEntity> getPortfoliosByClientId(@PathVariable Long clientId) {
        return portfolioService.getPortfoliosByClientId(clientId);
    }

    // Get all portfolios
    @GetMapping("/all")
    public List<PortfolioEntity> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    // Rebalance portfolio
    @PutMapping("/rebalance/{id}")
    public PortfolioEntity rebalancePortfolio(@PathVariable Long id) {
        return portfolioService.rebalancePortfolio(id);
    }
}
