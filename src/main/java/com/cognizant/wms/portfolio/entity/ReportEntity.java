package com.cognizant.wms.portfolio.entity;

import jakarta.persistence.*;

import java.util.Date;

public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "portfolioId", nullable = false)
    private PortfolioEntity portfolio;

    @Temporal(TemporalType.DATE)
    private Date reportDate;

    @Column(columnDefinition = "TEXT")
    private String performanceSummary;
}
