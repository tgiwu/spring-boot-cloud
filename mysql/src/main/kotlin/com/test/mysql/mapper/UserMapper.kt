package com.test.mysql.mapper

import com.test.mysql.module.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    @Select("select * from user ")
    fun queryAllUser() : List<User>
}