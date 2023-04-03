package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun add_user(user: User)

     @Update
     suspend fun updateUser(user: User)

    @Query("SELECT * FROM user_table order by id asc")
    fun read_all_data(): LiveData<List<User>>
}