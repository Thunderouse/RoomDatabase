package com.example.roomdatabase.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int,
    val first_name: String,
    val last_name: String,
    val age: Int,
): Parcelable
