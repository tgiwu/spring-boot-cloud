package com.test.ribbon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
class RibbonApplication {

    @Bean
    @LoadBalanced
    fun restTemplate() : RestTemplate = RestTemplate()
}

fun main(args: Array<String>) {
    runApplication<RibbonApplication>(*args)
}
