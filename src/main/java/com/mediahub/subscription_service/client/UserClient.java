package com.mediahub.subscription_service.client;

import com.mediahub.subscription_service.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/api/v1/users")
public interface UserClient {

    @GetMapping("/{id}")
    ApiResponse<Object> getUserById(@PathVariable("id") Long id);
}
