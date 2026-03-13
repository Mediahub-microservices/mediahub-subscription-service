package com.mediahub.subscription_service.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Plan planType;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    private BigDecimal price;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    void created(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void updated(){
        updatedAt = LocalDateTime.now();
    }
}