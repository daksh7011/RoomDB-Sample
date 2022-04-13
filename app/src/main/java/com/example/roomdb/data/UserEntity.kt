package com.example.roomdb.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomdb.UserModel

@Entity(tableName = "Users")
data class UserEntity(
    val uuid: String,
    val firstName: String,
    val lastName: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
) {
    fun toUserModel() = UserModel(uuid, firstName, lastName, id)
}