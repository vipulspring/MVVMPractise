package com.singhenterprises.mvvmexample.data.network.responses

import com.singhenterprises.mvvmexample.data.db.entities.User

public data class AuthResponse(
    val email: String?,
    val firstName: String?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val lastName: String?,
    val refreshToken: String?,
    val token: String?,
    val username: String?,
    val message: String?

)