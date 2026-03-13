package com.mediahub.subscription_service.dto.request;

import com.mediahub.subscription_service.domain.Plan;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubscriptionRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Plan planType;

    @NotNull
    private BigDecimal price;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;
}
