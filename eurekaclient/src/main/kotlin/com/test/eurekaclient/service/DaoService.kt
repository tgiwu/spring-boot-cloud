package com.test.eurekaclient.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "service-mysql")
interface DaoService {
    @RequestMapping(value = ["/allUsers"], method = [RequestMethod.GET])
    fun queryAllUser() : String
}