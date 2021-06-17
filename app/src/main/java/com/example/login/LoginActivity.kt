package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.login.databinding.ActivityMainBinding
import com.example.login.util.CommonUtils
import com.example.login.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var viewmodel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide();
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        init()

        CommonUtils.setHighLightedText(binding?.providing!!,resources.getString(R.string.learn_more))
    }

    private fun init(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding!!.viewmodel =viewmodel

        binding!!.buttonPanel.setOnClickListener(){
            Toast.makeText(this,resources.getText(R.string.details_submitted),Toast.LENGTH_LONG).show()
            finish()
        }

        binding!!.tvDontHavePan.setOnClickListener(){
            finish()
        }
    }
}