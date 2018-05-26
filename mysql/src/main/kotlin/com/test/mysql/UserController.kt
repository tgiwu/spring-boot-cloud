package com.test.mysql

import com.test.mysql.mapper.UserMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class UserController {
    @Resource
    lateinit var userMapper: UserMapper

    @GetMapping("/allUsers")
    fun queryAllUser() : String {
        val list = userMapper.queryAllUser()
        return "$list"
    }
}