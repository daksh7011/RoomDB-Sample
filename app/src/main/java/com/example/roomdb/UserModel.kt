package com.example.roomdb

import com.example.roomdb.data.UserEntity

data class UserModel(
    val uuid: String,
    val firstName: String,
    val lastName: String,
    val id: Int? = null,
) {
    fun toUserEntity() = UserEntity(uuid, firstName, lastName, id)
}