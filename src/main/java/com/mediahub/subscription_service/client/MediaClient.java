package com.mediahub.subscription_service.client;

import com.mediahub.subscription_service.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "media-service", path = "/api/v1/media")
public interface MediaClient {

    @GetMapping("/{id}")
    ApiResponse<Object> getMediaById(@PathVariable("id") Long id);
}
