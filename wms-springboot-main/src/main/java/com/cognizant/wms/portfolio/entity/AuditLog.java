package com.cognizant.wms.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
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
