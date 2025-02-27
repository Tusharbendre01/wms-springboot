package com.cognizant.wms.portfolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter  // ✅ Lombok generates getters and setters automatically
public class PortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private ClientEntity client;

    private Double totalValue;

    @Column(columnDefinition = "TEXT")  // ✅ JSON String Storage
    private String allocationSummary;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    // ✅ Manually add setters if Lombok is not working
    public void setAllocationSummary(String allocationSummary) {
        this.allocationSummary = allocationSummary;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
