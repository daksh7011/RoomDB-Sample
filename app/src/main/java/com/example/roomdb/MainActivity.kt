package com.example.roomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.roomdb.data.RoomDB
import com.example.roomdb.data.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coroutineScope.launch {
            insertUser()
        }
    }

    private fun provideDatabase(): RoomDB {
        return Room.databaseBuilder(
            application,
            RoomDB::class.java,
            "RoomDB Example"
        ).build()
    }

    private fun getUserDao(): UserDao {
        return provideDatabase().getUserDao()
    }

    private suspend fun getUsers(): List<UserModel> {
        return getUserDao().getAllUser().map { it.toUserModel() }
    }

    private suspend fun insertUser() {
        val userModel = UserModel(UUID.randomUUID().toString(), "John", "Doe")
        getUserDao().insertUser(userModel.toUserEntity())
    }
}