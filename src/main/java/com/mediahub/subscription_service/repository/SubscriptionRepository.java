package com.mediahub.subscription_service.repository;

import com.mediahub.subscription_service.domain.Subscription;
import com.mediahub.subscription_service.domain.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {

    List<Subscription> findByUserId(UUID userId);

    Optional<Subscription> findByUserIdAndStatus(UUID userId, SubscriptionStatus status);

}
