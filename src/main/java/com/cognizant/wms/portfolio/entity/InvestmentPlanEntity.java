package com.cognizant.wms.portfolio.entity;

import jakarta.persistence.*;

public class InvestmentPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private ClientEntity client;

    private String investmentObjective;

    @Enumerated(EnumType.STRING)
    private RiskAppetite riskAppetite; // ENUM: Low, Medium, High

    @Column(columnDefinition = "TEXT")
    private String allocationDetails;
}
