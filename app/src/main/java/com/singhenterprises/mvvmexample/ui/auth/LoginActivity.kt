package com.singhenterprises.mvvmexample.ui.auth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.singhenterprises.mvvmexample.R
import com.singhenterprises.mvvmexample.databinding.ActivityLoginBinding
import com.singhenterprises.mvvmexample.util.hide
import com.singhenterprises.mvvmexample.util.show
import com.singhenterprises.mvvmexample.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListener = this
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    override fun onStarted() {
        toast("Login Started")
        //progress_bar.show()
        binding.progressBar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            binding.progressBar.hide()
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        //Thread.sleep(2000)
       //binding.progressBar.hide()
        toast(message)
    }
}