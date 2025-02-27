package com.cognizant.wms.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@Setter
@Getter
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
