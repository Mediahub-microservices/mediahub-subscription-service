package com.mediahub.subscription_service.controller;

import com.mediahub.subscription_service.dto.ApiResponse;
import com.mediahub.subscription_service.dto.request.CreateSubscriptionRequest;
import com.mediahub.subscription_service.dto.response.SubscriptionResponse;
import com.mediahub.subscription_service.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    @PostMapping
    public ApiResponse<SubscriptionResponse> create(@Valid @RequestBody CreateSubscriptionRequest request) {
        return ApiResponse.success(
                service.createSubscription(request),
                "Subscription created");
    }

    @GetMapping("/{id}")
    public ApiResponse<SubscriptionResponse> getById(@PathVariable UUID id) {
        return ApiResponse.success(
                service.getSubscriptionById(id),
                "Subscription found");
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<SubscriptionResponse>> getUserSubscriptions(@PathVariable Long userId) {
        return ApiResponse.success(
                service.getUserSubscriptions(userId),
                "User subscriptions");
    }

    @PutMapping("/{id}/cancel")
    public ApiResponse<SubscriptionResponse> cancel(@PathVariable UUID id) {
        return ApiResponse.success(
                service.cancelSubscription(id),
                "Subscription cancelled");
    }

    @GetMapping("/user/{userId}/active")
    public ApiResponse<Boolean> hasActive(@PathVariable Long userId) {
        return ApiResponse.success(
                service.hasActiveSubscription(userId),
                "Active subscription status");
    }

    @GetMapping("/media-info/{mediaId}")
    public ApiResponse<Object> getMediaInfo(@PathVariable Long mediaId) {
        return ApiResponse.success(
                service.getMediaInfo(mediaId),
                "Media info retrieved via WebClient");
    }
}