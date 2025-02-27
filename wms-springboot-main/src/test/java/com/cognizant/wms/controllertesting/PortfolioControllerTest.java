package com.cognizant.wms.controllertesting;

import com.cognizant.wms.portfolio.controller.PortfolioController;
import com.cognizant.wms.portfolio.entity.PortfolioEntity;
import com.cognizant.wms.portfolio.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PortfolioControllerTest {

    @InjectMocks
    private PortfolioController portfolioController;

    @Mock
    private PortfolioService portfolioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePortfolio() {
        PortfolioEntity portfolio = new PortfolioEntity();
        when(portfolioService.savePortfolio(any(PortfolioEntity.class))).thenReturn(portfolio);

        PortfolioEntity result = portfolioController.savePortfolio(portfolio);
        assertNotNull(result);
        assertEquals(portfolio, result);
    }

    @Test
    public void testGetPortfolioById() {
        PortfolioEntity portfolio = new PortfolioEntity();
        when(portfolioService.getPortfolioById(1L)).thenReturn(portfolio);

        PortfolioEntity result = portfolioController.getPortfolioById(1L);
        assertNotNull(result);
        assertEquals(portfolio, result);
    }

    @Test
    public void testGetPortfoliosByClientId() {
        List<PortfolioEntity> portfolios = new ArrayList<>();
        when(portfolioService.getPortfoliosByClientId(1L)).thenReturn(portfolios);

        List<PortfolioEntity> result = portfolioController.getPortfoliosByClientId(1L);
        assertNotNull(result);
        assertEquals(portfolios, result);
    }

    @Test
    public void testGetAllPortfolios() {
        List<PortfolioEntity> portfolios = new ArrayList<>();
        when(portfolioService.getAllPortfolios()).thenReturn(portfolios);

        List<PortfolioEntity> result = portfolioController.getAllPortfolios();
        assertNotNull(result);
        assertEquals(portfolios, result);
    }

    @Test
    public void testRebalancePortfolio() {
        PortfolioEntity portfolio = new PortfolioEntity();
        when(portfolioService.rebalancePortfolio(1L)).thenReturn(portfolio);

        PortfolioEntity result = portfolioController.rebalancePortfolio(1L);
        assertNotNull(result);
        assertEquals(portfolio, result);
    }
}
