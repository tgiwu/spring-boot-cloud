package com.test.feign.client

import com.test.feign.fallback.UserFallback
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name="eureka-client", fallback=UserFallback::class)
interface UserFeignClient {
    @GetMapping("/listUsers")
    fun listUsers() : String
}