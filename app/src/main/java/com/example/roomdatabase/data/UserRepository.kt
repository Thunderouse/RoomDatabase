package com.example.roomdatabase.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.read_all_data()

    suspend fun addUser(user: User){
        userDao.add_user(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
}