package com.mediahub.subscription_service.dto.response;

import com.mediahub.subscription_service.domain.Plan;
import com.mediahub.subscription_service.domain.SubscriptionStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponse {

    private UUID id;

    private UUID userId;

    private Plan planType;

    private SubscriptionStatus status;

    private BigDecimal price;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
