package com.test.ribbon.client

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class UserManagementRibbonClient {
    @Autowired
    var restTemplate : RestTemplate? = null
    @Value("\${server.port}")
    var port : String = ""

    @GetMapping("/listUsersByRibbon")
    @HystrixCommand(fallbackMethod="listUsersByRibbonFallback")
    fun listUsersByRibbon()  = restTemplate!!.getForObject("http://eureka-client/listUsers", String::class.java)

    fun listUsersByRibbonFallback() : String = "listUsersByRibbonFallback异常 端口: $port"
}