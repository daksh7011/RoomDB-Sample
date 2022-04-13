package com.example.roomdb.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        UserEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class RoomDB : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}