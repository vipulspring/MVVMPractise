package com.singhenterprises.mvvmexample.ui.auth

import androidx.lifecycle.LiveData
import com.singhenterprises.mvvmexample.data.network.responses.AuthResponse
import retrofit2.Response

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: AuthResponse?)
    fun onFailure(message: String)

}