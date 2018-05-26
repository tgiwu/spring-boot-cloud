package com.test.feign.api

import com.test.feign.client.UserFeignClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserFeignApi {
    @Autowired
    var userFeignClient: UserFeignClient? = null

    @GetMapping("/listUsersByFeign")
    fun listUsers() : String = userFeignClient!!.listUsers()
}