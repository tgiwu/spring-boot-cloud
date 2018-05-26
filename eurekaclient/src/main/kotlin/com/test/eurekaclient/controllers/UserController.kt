package com.test.eurekaclient.controllers

import com.netflix.discovery.DiscoveryClient
import com.test.eurekaclient.service.DaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Value("\${server.port}")
    var serverPort: String = ""

//    @Value("\${aaa.name}")
//    var userName: String = ""

    @Autowired
    lateinit var daoService: DaoService

    @GetMapping("/listUsers")
    fun listUsers() : String{

        val users = daoService.queryAllUser()
//        val users = ArrayList<Map<String,  Any>>()
//        for (i in 0..5) {
//            val usr = HashMap<String, Any>()
//            usr["id"] = i
//            usr["name"] = "小明$i"
//            users.add(usr)
//        }
//        val gson = Gson()
        return " 服务器端口号:$serverPort  | 用户信息:  $users"
    }

}