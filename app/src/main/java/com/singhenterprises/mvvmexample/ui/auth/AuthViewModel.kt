package com.singhenterprises.mvvmexample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.singhenterprises.mvvmexample.data.repositories.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun loginBtn(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){

            authListener?.onFailure("Invalid Emmail or Password")

            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            val loginResponse = UserRepository().userLogin(email!!, password!!)
            if(loginResponse.isSuccessful) {
                authListener?.onSuccess(loginResponse.body())
            }
            else {
                authListener?.onFailure("Error Code: ${loginResponse.code()}" + loginResponse.body())
            }
        }
    }

}