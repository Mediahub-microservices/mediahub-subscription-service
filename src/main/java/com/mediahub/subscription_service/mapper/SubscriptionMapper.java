package com.mediahub.subscription_service.mapper;

import com.mediahub.subscription_service.domain.Subscription;
import com.mediahub.subscription_service.dto.response.SubscriptionResponse;

public class SubscriptionMapper {

    public static SubscriptionResponse toResponse(Subscription sub){
        return SubscriptionResponse.builder()
                .id(sub.getId())
                .userId(sub.getUserId())
                .planType(sub.getPlanType())
                .status(sub.getStatus())
                .price(sub.getPrice())
                .startDate(sub.getStartDate())
                .endDate(sub.getEndDate())
                .build();
    }
}
