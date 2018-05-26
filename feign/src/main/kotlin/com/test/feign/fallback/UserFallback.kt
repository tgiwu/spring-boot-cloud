package com.test.feign.fallback

import com.test.feign.client.UserFeignClient
import org.springframework.stereotype.Component

@Component
class UserFallback : UserFeignClient {
    override fun listUsers(): String = "服务调用失败"
}