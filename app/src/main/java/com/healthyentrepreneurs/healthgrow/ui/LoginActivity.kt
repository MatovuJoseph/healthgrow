package com.healthyentrepreneurs.healthgrow.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.healthyentrepreneurs.healthgrow.R
import com.healthyentrepreneurs.healthgrow.databinding.ActivityLoginBinding
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = " "

        /*default*/
        binding.codeInputLayout.isVisible = false
        binding.submitBtn.isEnabled = false

        binding.verifyBtn.setOnClickListener {
            binding.codeInputLayout.isVisible = true
            binding.phoneInputLayout.isVisible = false

            /*dummy - timer to represent sms code callback*/
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    runOnUiThread {
                        binding.codeInput.setText("5564")
                        binding.submitBtn.isEnabled = true
                    }

                }
            },3000)
        }

        binding.submitBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finishAffinity()
        }
    }
}