package com.mediahub.subscription_service.service;

import com.mediahub.subscription_service.dto.request.CreateSubscriptionRequest;
import com.mediahub.subscription_service.dto.response.SubscriptionResponse;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {

    SubscriptionResponse createSubscription(CreateSubscriptionRequest request);

    SubscriptionResponse getSubscriptionById(UUID id);

    List<SubscriptionResponse> getUserSubscriptions(Long userId);

    SubscriptionResponse cancelSubscription(UUID id);

    boolean hasActiveSubscription(Long userId);

    Object getMediaInfo(Long mediaId);

}
