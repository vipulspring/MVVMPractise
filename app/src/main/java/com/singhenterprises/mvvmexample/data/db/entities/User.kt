package com.singhenterprises.mvvmexample.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0
@Entity
data class User(
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val refreshToken: String,
    val token: String,
    val username: String
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID

}