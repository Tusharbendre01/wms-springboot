package com.cognizant.wms.portfolio.entity;

import jakarta.persistence.*;

import java.util.Date;
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private String eventDescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimestamp;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private ComplianceStatus complianceStatus;
}
