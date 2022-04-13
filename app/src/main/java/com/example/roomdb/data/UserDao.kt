package com.example.roomdb.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("select * from users")
    suspend fun getAllUser(): List<UserEntity>

    @Query("select * from users where uuid=:userUuid")
    suspend fun getUserByUuid(userUuid: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(userEntity: UserEntity)

    @Query("update users set firstName=:firstName where uuid=:uuid")
    suspend fun updateUserWithUuid(firstName: String, uuid: String)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

    @Query("delete from users where uuid=:userUuid")
    suspend fun deleteUserWithUuid(userUuid: String)
}