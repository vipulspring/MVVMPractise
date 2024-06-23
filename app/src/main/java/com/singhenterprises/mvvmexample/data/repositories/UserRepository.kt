package com.singhenterprises.mvvmexample.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.singhenterprises.mvvmexample.data.network.MyApi
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback

class UserRepository {
    fun userLogin(email: String, password: String): LiveData<String> {

        val loginResponse = MutableLiveData<String>()
        Log.i("TAG", "userLogin: ")
        MyApi().userLogin(email,password)
            .enqueue(object: Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: retrofit2.Response<ResponseBody>
                ) {
                    Log.i("TAG", "onResponse: " + response.message().toString())
                    if(response.isSuccessful){
                        loginResponse.value = response.body()?.string()
                    }else{
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.i("TAG", "onFailure: " + t.message.toString())
                    loginResponse.value = t.message
                }

            })
        return loginResponse
    }
}