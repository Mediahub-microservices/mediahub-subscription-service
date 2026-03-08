package com.mediahub.subscription_service.service.impl;

import com.mediahub.subscription_service.domain.Subscription;
import com.mediahub.subscription_service.domain.SubscriptionStatus;
import com.mediahub.subscription_service.dto.request.CreateSubscriptionRequest;
import com.mediahub.subscription_service.dto.response.SubscriptionResponse;
import com.mediahub.subscription_service.exception.ResourceNotFoundException;
import com.mediahub.subscription_service.mapper.SubscriptionMapper;
import com.mediahub.subscription_service.repository.SubscriptionRepository;
import com.mediahub.subscription_service.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;

    @Override
    public SubscriptionResponse createSubscription(CreateSubscriptionRequest request) {

        Subscription sub = Subscription.builder()
                .userId(request.getUserId())
                .planType(request.getPlanType())
                .price(request.getPrice())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(SubscriptionStatus.ACTIVE)
                .build();

        repository.save(sub);

        return SubscriptionMapper.toResponse(sub);
    }

    @Override
    public SubscriptionResponse getSubscriptionById(UUID id) {

        Subscription sub = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));

        return SubscriptionMapper.toResponse(sub);
    }

    @Override
    public List<SubscriptionResponse> getUserSubscriptions(UUID userId) {

        return repository.findByUserId(userId)
                .stream()
                .map(SubscriptionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionResponse cancelSubscription(UUID id) {

        Subscription sub = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));

        sub.setStatus(SubscriptionStatus.CANCELLED);

        repository.save(sub);

        return SubscriptionMapper.toResponse(sub);
    }

    @Override
    public boolean hasActiveSubscription(UUID userId) {

        return repository.findByUserIdAndStatus(userId, SubscriptionStatus.ACTIVE)
                .isPresent();
    }
}